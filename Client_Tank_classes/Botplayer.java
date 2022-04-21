package Client_Tank_classes;

import Ideaone.Client_Tank_classes.Map;
import Ideaone.Client_Tank_classes.Player;
import Ideaone.Client_Tank_classes.Position;

public class Botplayer implements Player {
    Map map;

    Position position;

    int x = 0;

    int y = 0;

    public void moveRight() {
        try {
            getPosition();
            if (this.map.getValueAt(this.position.getY(), this.position.getX() + 1) == '0' || this.map.getValueAt(this.position.getY(), this.position.getX() + 1) == '4') {
                this.map.setValueAt(this.y, this.x + 1, 'B');
                this.map.setValueAt(this.y, this.x, '0');
                this.map.print();
            }
        } catch (Exception e) {
            this.map.setValueAt(this.y, this.x, this.map.getValueAt(this.position.getY(), this.position.getX()));
        }
    }

    public void moveLeft() {
        try {
            getPosition();
            if (this.map.getValueAt(this.position.getY(), this.position.getX() - 1) == '0' || this.map.getValueAt(this.position.getY(), this.position.getX() - 1) == '4') {
                this.map.setValueAt(this.y, this.x - 1, 'B');
                this.map.setValueAt(this.y, this.x, '0');
                this.map.print();
            }
        } catch (Exception e) {
            this.map.setValueAt(this.y, this.x, this.map.getValueAt(this.position.getY(), this.position.getX()));
        }
    }

    public void moveUp() {
        try {
            getPosition();
            if (this.map.getValueAt(this.position.getY() - 1, this.position.getX()) == '0' || this.map.getValueAt(this.position.getY() - 1, this.position.getX()) == '4') {
                this.map.setValueAt(this.y - 1, this.x, 'B');
                this.map.setValueAt(this.y, this.x, '0');
                this.map.print();
            }
        } catch (Exception e) {
            this.map.setValueAt(this.y, this.x, this.map.getValueAt(this.position.getY(), this.position.getX()));
        }
    }

    public void moveDown() {
        try {
            getPosition();
            if (this.map.getValueAt(this.position.getY() + 1, this.position.getX()) == '0' || this.map.getValueAt(this.position.getY() + 1, this.position.getX()) == '4') {
                this.map.setValueAt(this.y + 1, this.x, 'B');
                this.map.setValueAt(this.y, this.x, '0');
                this.map.print();
            }
        } catch (Exception e) {
            this.map.setValueAt(this.y, this.x, this.map.getValueAt(this.position.getY(), this.position.getX()));
        }
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Position getPosition() {
        for (int i = 0; i < this.map.getSize(); i++) {
            for (int j = 0; j < this.map.getSize(); j++) {
                if (this.map.getValueAt(i, j) == 'B') {
                    this.x = j;
                    this.y = i;
                    break;
                }
            }
        }
        return this.position = new Position(this.x, this.y);
    }
}
