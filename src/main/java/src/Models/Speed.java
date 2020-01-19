package src.Models;


public class Speed {
  private Integer speed;

  public Speed() {
    this(0);
  }

  public Speed(Integer speed) {
    this.set(speed);
  }

  public Integer get() {
    return this.speed;
  }

  public Speed set(Integer speed) {
    this.speed = speed;

    return this;
  }
}
