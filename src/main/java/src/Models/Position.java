package src.Models;


public class Position {
  private Integer x;
  private Integer y;

  public Position() {
    this(0, 0);
  }

  public Position (Position position) {
    this.setX(position.getX());
    this.setY(position.getY());
  }

  public Position(Integer x, Integer y) {
    this.setX(x).setY(y);
  }

  public Integer getX() {
    return this.x;
  }

  public Position setX(Integer x) {
    if (x < 0) {
      throw new Error("Coordinate X must be 0 or greater!");
    }
    this.x = x;

    return this;
  }

  public Integer getY() {
    return this.y;
  }

  public Position setY(Integer y) {
    if (y < 0) {
      throw new Error("Coordinate Y must be 0 or greater!");
    }
    this.y = y;

    return this;
  }

  public void move(Move move) {
    this.x += move.getX();
    this.y += move.getY();
  }
}
