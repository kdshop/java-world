package src.Models;


public class Initiative {
  private Integer initiative = 0;

  public Initiative() {
    this(0);
  }

  public Initiative(Integer initiative) {
    this.set(initiative);
  }

  public Integer get() {
    return this.initiative;
  }

  public Initiative set(Integer power) {
    this.initiative = power;

    return this;
  }
}

