import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.Abstracts.Organism;
import src.Models.Position;


class ServerMessage {
  static class OrganismApiModel {
    Position position;
    String sign;

    OrganismApiModel(Organism organism) {
      Position position = new Position(organism.getPosition());
      this.position = position.setX(position.getX() + 1).setY(position.getY() + 1);
      this.sign = organism.getSign().get();
    }
  }
  private List<OrganismApiModel> data;

  ServerMessage(ArrayList<Organism> organisms) {
    data = organisms.stream().map(OrganismApiModel::new).collect(Collectors.toList());
  }
}