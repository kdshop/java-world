import io.reactivex.rxjava3.disposables.Disposable;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(
    value="/",
    encoders = ServerEncoder.class
)
public class WSEndpoint {
  private Disposable subscription;

  @OnOpen
  public void onOpen(Session session) {
    System.out.println("Client " + session.getId() + " connected!");

    this.subscription = Project.getInstance()
        .getWSStream()
        .subscribe(wsMessage -> {
              System.out.println(wsMessage + " for client: " + session.getId() + " sent!");
              session.getBasicRemote().sendObject(wsMessage);
            },
            System.out::println
        );
  }

  @OnError
  public void onError(Throwable e) {
    e.printStackTrace();
  }

  @OnClose
  public void onClose(Session session) {
    this.subscription.dispose();
    System.out.println("Client " + session.getId() + " disconnected!");
  }
}