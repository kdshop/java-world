package src.Entities;

import src.Abstracts.Organism;
import src.Models.*;

public class Sheep extends Organism {
  public Sheep() {
    this.setPower(new Power(3));
    this.setInitiative(new Initiative(3));
    this.setLiveLength(new LiveLength(10));
    this.setPowerToReproduce(new PowerToReproduce(8));
    this.setSign(new Sign("S"));
    this.setSpeed(new Speed(1));
  }
}
