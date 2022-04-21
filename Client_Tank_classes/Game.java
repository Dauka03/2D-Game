package Client_Tank_classes;

import Ideaone.Client_Tank_classes.InvalidMapException;
import Ideaone.Client_Tank_classes.Map;
import Ideaone.Client_Tank_classes.Player;

public class Game {
    Map map;

    Player player;

    public Game(Map map) throws InvalidMapException {
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addPlayer(Player player) {
        this.player = player;
        this.player.setMap(this.map);
    }
}
