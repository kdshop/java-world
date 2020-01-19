package src;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import src.Abstracts.Organism;
import src.Entities.Grass;
import src.Entities.Mushroom;
import src.Entities.Sheep;
import src.Entities.Wolf;


interface Inhabitant {
  ArrayList<Organism> getPopulation();
  void nextEra();
}

public class World implements Inhabitant {
  private Population population = src.Population.getInstance();

  World() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    this.population.createEntity(Sheep.class);
    this.population.createEntity(Sheep.class);
    this.population.createEntity(Sheep.class);
    this.population.createEntity(Grass.class);
    this.population.createEntity(Grass.class);
    this.population.createEntity(Mushroom.class);
    this.population.createEntity(Mushroom.class);
    this.population.createEntity(Mushroom.class);
    this.population.createEntity(Wolf.class);
  }

  @Override
  public ArrayList<Organism> getPopulation() {
    return this.population.get();
  }

  @Override
  public void nextEra() {
    this.population.get().forEach(Organism::move);
    this.population.passageOfTime();
    this.population.giftOfLife();
    this.population.reproduce();
  }
}
