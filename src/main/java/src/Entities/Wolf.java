package src.Entities;

import src.Abstracts.Organism;
import src.Models.*;

public class Wolf extends Organism {
  public Wolf() {
    this.setPower(new Power(6));
    this.setInitiative(new Initiative(5));
    this.setLiveLength(new LiveLength(15));
    this.setPowerToReproduce(new PowerToReproduce(14));
    this.setSign(new Sign("W"));
    this.setSpeed(new Speed(2));
  }
}
