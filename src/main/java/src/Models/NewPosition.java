package src.Models;

public class NewPosition {
  private Position position = null;
  private boolean isThereAny = false;

  public NewPosition(Position position) {
    this.setPosition(position);
    this.setIsThereAny(true);
  }

  public NewPosition(boolean isThereAny) {
    this.setIsThereAny(isThereAny);
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public boolean isThereAny() {
    return isThereAny;
  }

  public void setIsThereAny(boolean thereAny) {
    isThereAny = thereAny;
  }
}
