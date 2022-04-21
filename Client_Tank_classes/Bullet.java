package Client_Tank_classes;

import Ideaone.Client_Tank_classes.Tank;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Bullet extends Rectangle {
    private boolean status = true;

    public Bullet(Tank tank) {
        this.status = true;
        setWidth(5.0D);
        setHeight(5.0D);
        setRotate(tank.getRotate());
        if (tank.getRotate() == 0.0D) {
            setX(tank.getX() + 13.0D);
            setY(tank.getY());
        } else if (tank.getRotate() == 180.0D) {
            setX(tank.getX() + 13.0D);
            setY(tank.getY() + 38.0D);
        } else if (tank.getRotate() == 270.0D) {
            setX(tank.getX());
            setY(tank.getY() + 16.0D);
        } else if (tank.getRotate() == 90.0D) {
            setX(tank.getX() + 38.0D);
            setY(tank.getY() + 16.0D);
        }
        setFill((Paint) Color.RED);
        setStroke((Paint) Color.RED);
        if (getX() < 0.0D || getX() > 500.0D || getY() < 0.0D || getY() > 500.0D)
            this.status = false;
    }

    public void fire(Ideaone.Client_Tank_classes.Bullet bullet) {
        if (bullet.getRotate() == 0.0D) {
            bullet.setY(bullet.getY() - 3.0D);
            bullet.setX(bullet.getX());
        } else if (bullet.getRotate() == 90.0D) {
            bullet.setY(bullet.getY());
            bullet.setX(bullet.getX() + 3.0D);
        } else if (bullet.getRotate() == 180.0D) {
            bullet.setX(bullet.getX());
            bullet.setY(bullet.getY() + 3.0D);
        } else if (bullet.getRotate() == 270.0D) {
            bullet.setX(bullet.getX() - 3.0D);
            bullet.setY(bullet.getY());
        }
    }

    boolean getStatus() {
        return this.status;
    }
}
