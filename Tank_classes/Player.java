package Tank_classes;

import Ideaone.Tank_classes.Map;
import Ideaone.Tank_classes.Position;

public interface Player {
    void moveRight();

    void moveLeft();

    void moveUp();

    void moveDown();

    void setMap(Map paramMap);

    Position getPosition();
}
