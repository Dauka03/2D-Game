package Client_Tank_classes;

import Ideaone.Client_Tank_classes.Map;
import Ideaone.Client_Tank_classes.Player;
import Ideaone.Client_Tank_classes.Position;

public class MyPlayer implements Player {
    private Map map;

    public Position position;

    private int x;

    private int y;

    private char temp;

    public void setMap(Map map) {
        this.map = map;
    }

    public Position getPosition() {
        for (int i = 0; i < this.map.getSize(); i++) {
            for (int j = 0; j < this.map.getSize(); j++) {
                if (this.map.getValueAt(i, j) == 'P') {
                    this.x = j;
                    this.y = i;
                    break;
                }
            }
        }
        return this.position = new Position(this.x, this.y);
    }

    public void moveRight() {
        try {
            getPosition();
            if (this.map.getValueAt(this.position.getY(), this.position.getX() + 1) == '0' || this.map.getValueAt(this.position.getY(), this.position.getX() + 1) == '4') {
                this.map.setValueAt(this.y, this.x + 1, 'P');
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
                this.map.setValueAt(this.y, this.x - 1, 'P');
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
                this.map.setValueAt(this.y - 1, this.x, 'P');
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
                this.map.setValueAt(this.y + 1, this.x, 'P');
                this.map.setValueAt(this.y, this.x, '0');
                this.map.print();
            }
        } catch (Exception e) {
            this.map.setValueAt(this.y, this.x, this.map.getValueAt(this.position.getY(), this.position.getX()));
        }
    }
}
