package src.Models;


public class Move {
  private Integer x;
  private Integer y;

  public Move() {
    this(0, 0);
  }

  public Move(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  public Integer getX() {
    return this.x;
  }

  public Move setX(Integer x) {
    this.x = x;

    return this;
  }

  public Integer getY() {
    return this.y;
  }

  public Move setY(Integer y) {
    this.y = y;

    return this;
  }
}
