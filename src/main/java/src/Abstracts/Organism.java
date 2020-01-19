package src.Abstracts;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import src.Config;
import src.God;
import src.Models.*;
import src.Population;


public abstract class Organism {
  private PowerToReproduce powerToReproduce = new PowerToReproduce();
  private Power power = new Power();
  private Initiative initiative = new Initiative();
  private LiveLength liveLength = new LiveLength();
  private Sign sign = new Sign();
  private Worlds worlds = new Worlds();
  private Position position = null;
  private Speed speed = new Speed();
  private Population population = src.Population.getInstance();
  private God god;

  public Organism() {};

  public void cloneEntity() {
    if (this.population.get().size() == Math.pow(Config.WORLD_SIZE, 2)) {
      return;
    }

    Organism cloned = null;
    NewPosition newPosition = this.population.getFreeSpot(this.getPosition());

    if (!newPosition.isThereAny()) {
      return;
    }

    try {
       cloned = this.getClass().getDeclaredConstructor().newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
    }

    assert cloned != null;

    Position position = newPosition.getPosition();
    cloned.setPosition(position);
    cloned.believe(this.god);
    this.setPower(new Power(this.getPower().get() - this.getPowerToReproduce().get()));
    this.population.addEntity(cloned);
  };

  public void increasePower() {
    this.getPower().increasePower();
  }

  public void move() {
    if (this.position == null) {
      Integer x = new Random().nextInt(Config.WORLD_SIZE);
      Integer y = new Random().nextInt(Config.WORLD_SIZE);

      while (this.population.populationDistribution[x][y]) {
        x = new Random().nextInt(Config.WORLD_SIZE);
        y = new Random().nextInt(Config.WORLD_SIZE);
      }
      this.position = new Position(x, y);
      this.population.populationDistribution[x][y] = true;
    } else {
      Integer speed = this.speed.get();

      if (speed == 0) {
        return;
      }

      Integer move_x = new Random().nextInt(speed + speed + 1) - speed;
      Integer move_y = new Random().nextInt(speed + speed + 1) - speed;
      Integer new_x = this.position.getX() + move_x;
      Integer new_y = this.position.getY() + move_y;

      if (!this.population.isPositionLegal(new_x, new_y)) {
        return;
      }

      if (!this.population.populationDistribution[new_x][new_y]) {
        this.population.populationDistribution[this.position.getX()][this.position.getY()] = false;
        this.position.move(new Move(move_x, move_y));
        this.population.populationDistribution[new_x][new_y] = true;
      } else {
        if (!this.position.getX().equals(new_x) &&  !this.position.getY().equals(new_y)) {
          this.god.godsEars.onNext(new Conflict(this.hashCode(), new_x, new_y));
        }
      }
    }
  }

  public void believe(God god) {
    this.god = god;
  }

  public PowerToReproduce getPowerToReproduce() {
    return this.powerToReproduce;
  }

  public Organism setPowerToReproduce(PowerToReproduce powerToReproduce) {
    this.powerToReproduce = powerToReproduce;

    return this;
  }

  public Power getPower() {
    return this.power;
  }

  public Organism setPower(Power power) {
    this.power = power;

    return this;
  }

  public Initiative getInitiative() {
    return this.initiative;
  }

  public Organism setInitiative(Initiative initiative) {
    this.initiative = initiative;

    return this;
  }

  public LiveLength getLiveLength() {
    return this.liveLength;
  }

  public Organism setLiveLength(LiveLength liveLength) {
    this.liveLength = liveLength;

    return this;
  }

  public Sign getSign() {
    return this.sign;
  }

  public Organism setSign(Sign sign) {
    this.sign = sign;

    return this;
  }

  public Worlds getWorlds() {
    return this.worlds;
  }

  public Organism setWorlds(Worlds world) {
    this.worlds = world;

    return this;
  }

  public Position getPosition() {
    return this.position;
  }

  public Organism setPosition(Position position) {
    this.position = position;

    return this;
  }

  public Organism setWorld(Worlds.type type) {
    this.worlds.set(type);

    return this;
  }

  public Worlds.type getWorld() {
    return this.worlds.get();
  }

  public Organism setSpeed(Speed speed) {
    this.speed = speed;

    return this;
  }

  public Speed getSpeed() {
    return this.speed;
  }
}