import com.google.gson.Gson;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;


public class ServerEncoder implements javax.websocket.Encoder.Text<ServerMessage> {
  private static Gson gson = new Gson();

  @Override
  public String encode(ServerMessage projekt) throws EncodeException {
    return gson.toJson(projekt);
  }

  @Override
  public void init(EndpointConfig endpointConfig) {
    // Custom initialization logic
  }

  @Override
  public void destroy() {
    // Close resources
  }
}