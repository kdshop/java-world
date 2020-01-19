package src;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import src.Abstracts.Organism;


interface WorldServiceInterface {
  ArrayList<Organism> getCurrentState();
  void nextTurn();
}

public class WorldService implements WorldServiceInterface {
  private World world;

  public WorldService() {
    try {
      this.world = new World();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Organism> getCurrentState() {
    return this.world.getPopulation();
  }

  public void nextTurn() {
    this.world.nextEra();
  }
}
