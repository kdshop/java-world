package src;

import io.reactivex.rxjava3.subjects.ReplaySubject;

import src.Abstracts.Organism;
import src.Entities.Mushroom;
import src.Models.Conflict;
import src.Models.LiveLength;
import src.Models.Power;


interface Celestial {
  private void finalVerdict(Conflict conflict) {}
}

public class God implements Celestial {
  public ReplaySubject<Conflict> godsEars = ReplaySubject.create();

  God() {
    this.godsEars.subscribe(this::finalVerdict, System.out::println);
  }

  private void finalVerdict(Conflict conflict) {
    Population population = src.Population.getInstance();
    Organism attacker = population.getByHashcode(conflict.getHashCode());
    Organism target = population.getByPosition(conflict.getX(), conflict.getY());

    if (attacker.getClass() == target.getClass()) {
      return;
    }

    if (attacker.getInitiative().get() > target.getInitiative().get()) {
      attacker.setPower(new Power(target.getPower().get() + attacker.getPower().get()));
    }

    if (target.getInitiative().get() > attacker.getInitiative().get()) {
      target.setPower(new Power(attacker.getPower().get() + target.getPower().get()));
    }

    if (target.getClass() == Mushroom.class || attacker.getClass() == Mushroom.class) {
      target.setLiveLength(new LiveLength(0));
      attacker.setLiveLength(new LiveLength(0));
    }



    System.out.println(attacker);
    System.out.println(target);
  }
}
