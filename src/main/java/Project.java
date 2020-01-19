import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import src.Abstracts.Organism;
import src.Config;
import src.WorldService;


public final class Project {
  private static Project PROJECT;
  private PublishSubject<ArrayList<Organism>> heartbeat = PublishSubject.create();

  Project() {
    WorldService worldService = new WorldService();

    Observable.interval(Config.PERIOD, Config.TIME_UNIT).subscribe(aLong -> {
      System.out.println("Turn: " + aLong);
      worldService.nextTurn();
      this.heartbeat.onNext(worldService.getCurrentState());
    }, System.out::println);
  }

  Observable<ServerMessage> getWSStream() {
    return this.heartbeat.map(ServerMessage::new);
  };

  static Project getInstance() {
    if (PROJECT == null) {
      PROJECT = new Project();
    }

    return PROJECT;
  }
}


