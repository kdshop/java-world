package src.Models;


public class Worlds {
  private type world;
  public enum type {
    ziemia, mars
  }

  public Worlds(type world) {
    this.set(world);
  }

  public Worlds() {
    this(type.ziemia);
  }

  public Worlds.type get() {
    return this.world;
  }

  public Worlds set(Worlds.type wtype) {
    this.world = wtype;

    return this;
  }
}
