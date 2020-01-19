package src.Models;


public class Conflict {
  private int hashCode;
  private Integer x;
  private Integer y;

  public Conflict(int hashCode, Integer x, Integer y) {
    this.setHashCode(hashCode);
    this.setX(x);
    this.setY(y);
  }

  public int getHashCode() {
    return hashCode;
  }

  public Conflict setHashCode(int hashCode) {
    this.hashCode = hashCode;

    return this;
  }

  public Integer getX() {
    return x;
  }

  public Conflict setX(Integer x) {
    this.x = x;

    return this;
  }

  public Integer getY() {
    return y;
  }

  public Conflict setY(Integer y) {
    this.y = y;

    return this;
  }
}
