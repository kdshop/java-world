package src;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import src.Abstracts.Organism;
import src.Models.LiveLength;
import src.Models.NewPosition;
import src.Models.Position;


interface Group {
  static Population getInstance() {
    throw new Error("Singleton not implemented");
  }
  ArrayList<Organism> get();
  Population set(ArrayList<Organism> organisms);
  Organism getByPosition(Integer x, Integer y);
  Organism getByHashcode(int hashcode);
  <T extends Organism> void createEntity(Class<T> organism) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
  void passageOfTime();
  void reproduce();
  void giftOfLife();
  NewPosition getFreeSpot(Position position);
  boolean isPositionLegal(Integer x, Integer y);
}

public class Population implements Group {
  public Boolean[][] populationDistribution = new Boolean[Config.WORLD_SIZE][Config.WORLD_SIZE];
  private static final Population instance = new Population();
  private God god = new God();
  private ArrayList<Organism> registry = new ArrayList<>();

  private Population() {
    for (Boolean[] row: populationDistribution)
      Arrays.fill(row, false);
  }

  public static Population getInstance() {
    return instance;
  }

  public ArrayList<Organism> get() {
    return this.registry;
  }

  public Organism getByPosition(Integer x, Integer y) {
    return this.registry.stream()
        .filter(organism -> organism.getPosition().getX().equals(x) && organism.getPosition().getY().equals(y))
        .findFirst()
        .orElse(null);
  }

  public Organism getByHashcode(int hashcode) {
    return this.registry.stream()
        .filter(organism -> organism.hashCode() == hashcode).findFirst()
        .orElse(null);
  }

  public void addEntity(Organism organism) {
    this.populationDistribution[organism.getPosition().getX()][organism.getPosition().getY()] = true;
    this.registry.add(organism);
  }

  public <T extends Organism> void createEntity(Class<T> organism) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    if (this.registry.size() == Math.pow(Config.WORLD_SIZE, 2)) {
      return;
    }

    Organism specimen = organism.getDeclaredConstructor().newInstance();
    specimen.believe(this.god);
    this.registry.add(specimen);
  }

  public void passageOfTime() {
    this.registry.removeIf(organism -> {
      if (organism.getLiveLength().get() <= 0) {
        Position position = organism.getPosition();
        this.populationDistribution[position.getX()][position.getY()] = false;
        System.out.println(organism + " deceased.");

        return true;
      }
      return false;
    });
    this.registry.forEach(organism -> organism.setLiveLength(new LiveLength(organism.getLiveLength().get() - 1)));
  }

  public void reproduce() {
    ArrayList<Organism> clonedList = (ArrayList<Organism>) this.registry.clone();
    clonedList.forEach(organism -> {
      if (organism.getPower().get() >= organism.getPowerToReproduce().get()) {
        organism.cloneEntity();
      }
    });
  }

  public void giftOfLife() {
    this.registry.forEach(Organism::increasePower);
  }

  public NewPosition getFreeSpot(Position position) {
    Integer x = position.getX();
    Integer y = position.getY();

    if (this.isPositionLegal(x - 1, y - 1) && !this.populationDistribution[x - 1][y - 1]) {
      return new NewPosition(new Position(x - 1, y - 1));
    }
    if (this.isPositionLegal(x - 1, y) && !this.populationDistribution[x - 1][y]) {
      return new NewPosition(new Position(x - 1, y));
    }
    if (this.isPositionLegal(x - 1, y + 1) && !this.populationDistribution[x - 1][y + 1]) {
      return new NewPosition(new Position(x - 1, y + 1));
    }
    if (this.isPositionLegal(x, y + 1) && !this.populationDistribution[x][y + 1]) {
      return new NewPosition(new Position(x, y + 1));
    }
    if (this.isPositionLegal(x + 1, y + 1) && !this.populationDistribution[x + 1][y + 1]) {
      return new NewPosition(new Position(x + 1, y + 1));
    }
    if (this.isPositionLegal(x + 1, y) && !this.populationDistribution[x + 1][y]) {
      return new NewPosition(new Position(x + 1, y));
    }
    if (this.isPositionLegal(x + 1, y - 1) && !this.populationDistribution[x + 1][y - 1]) {
      return new NewPosition(new Position(x + 1, y - 1));
    }
    if (this.isPositionLegal(x, y - 1) && !this.populationDistribution[x][y - 1]) {
      return new NewPosition(new Position(x, y - 1));
    }

    return new NewPosition(false);
  }

  public boolean isPositionLegal(Integer x, Integer y) {
    return x >= 0 && x < Config.WORLD_SIZE && y >= 0 && y < Config.WORLD_SIZE;
  };

  public Population set(ArrayList<Organism> organisms) {
    this.registry = organisms;

    return this;
  }

}
