package src.Models;


public class Power {
  private Integer power;

  public Power() {
    this(0);
  }

  public Power(Integer power) {
    this.set(power);
  }

  public void increasePower() {
    this.set(this.get() + 1);
  }

  public Integer get() {
    return this.power;
  }

  public Power set(Integer power) {
    this.power = power;

    return this;
  }
}

