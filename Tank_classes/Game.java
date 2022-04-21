package Tank_classes;

import Ideaone.Tank_classes.InvalidMapException;
import Ideaone.Tank_classes.Map;
import Ideaone.Tank_classes.Player;

import java.util.ArrayList;

public class Game {
    Map map;

    ArrayList<Player> players = new ArrayList<>();

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
        this.players.add(this.player);
        System.out.println(");
    }
}
