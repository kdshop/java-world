package src.Entities;

import src.Abstracts.Organism;
import src.Models.*;

public class Grass extends Organism {
  public Grass() {
    this.setLiveLength(new LiveLength(6));
    this.setPowerToReproduce(new PowerToReproduce(4));
    this.setSign(new Sign("G"));
  }
}
