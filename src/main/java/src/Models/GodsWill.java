package src.Models;


public class GodsWill {
  private int target;
  private type type;
  private Integer modifiler;
  public enum type {
    power,
    initiative,
    liveLength,
    powerToReproduce,
    speed
  }

  public GodsWill(int target, GodsWill.type type, Integer modifiler) {
    this.setTarget(target);
    this.setType(type);
    this.setModifiler(modifiler);
  }

  public int getTarget() {
    return target;
  }

  public GodsWill setTarget(int target) {
    this.target = target;

    return this;
  }

  public GodsWill.type getType() {
    return type;
  }

  public GodsWill setType(GodsWill.type type) {
    this.type = type;

    return this;
  }

  public Integer getModifiler() {
    return modifiler;
  }

  public GodsWill setModifiler(Integer modifiler) {
    this.modifiler = modifiler;

    return this;
  }
}
