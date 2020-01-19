package src.Models;


public class PowerToReproduce {
  private Integer powerToReproduce;

  public PowerToReproduce() {
    this(3);
  }

  public PowerToReproduce(Integer powerToReproduce) {
    this.set(powerToReproduce);
  }

  public Integer get() {
    return this.powerToReproduce;
  }

  public PowerToReproduce set(Integer powerToReproduce) {
    if (powerToReproduce <= 0) {
      throw new Error("PowerToReproduce must be 1 or more!");
    }

    this.powerToReproduce = powerToReproduce;

    return this;
  }
}
