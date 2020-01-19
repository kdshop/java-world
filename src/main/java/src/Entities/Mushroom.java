package src.Entities;

import src.Abstracts.Organism;
import src.Models.*;

public class Mushroom extends Organism {
  public Mushroom() {
    this.setLiveLength(new LiveLength(10));
    this.setPowerToReproduce(new PowerToReproduce(6));
    this.setSign(new Sign("M"));
  }
}
