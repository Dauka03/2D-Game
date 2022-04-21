package Client_Tank_classes;

import Ideaone.Client_Tank_classes.Botplayer;
import Ideaone.Client_Tank_classes.MyPlayer;
import Ideaone.Client_Tank_classes.Position;
import javafx.scene.image.ImageView;

public class BotTank extends ImageView {
    Botplayer botplayer;

    public BotTank(Botplayer botplayer) {
        super("Ideaone/img/bot.png");
        Position position = botplayer.getPosition();
        this.botplayer = botplayer;
        setX(position.getX() * 33.3D);
        setY(position.getY() * 33.3D);
        setFitWidth(30.0D);
        setFitHeight(40.0D);
    }

    public void moveDown() {
        this.botplayer.getPosition();
        if (this.botplayer.map.getValueAt(this.botplayer.position.getY() + 1, this.botplayer.position.getX()) == '0' || this.botplayer.map.getValueAt(this.botplayer.position.getY() + 1, this.botplayer.position.getX()) == '4') {
            setY(getY() + 33.0D);
            if (getRotate() != 180.0D)
                setRotate(180.0D);
            this.botplayer.moveDown();
        } else {
            setY(getY());
            this.botplayer.moveDown();
            if (getRotate() != 180.0D)
                setRotate(180.0D);
        }
    }

    public void moveUp() {
        this.botplayer.getPosition();
        if (this.botplayer.map.getValueAt(this.botplayer.position.getY() - 1, this.botplayer.position.getX()) == '0' || this.botplayer.map.getValueAt(this.botplayer.position.getY() - 1, this.botplayer.position.getX()) == '4') {
            setY(getY() - 33.0D);
            if (getRotate() != 0.0D)
                setRotate(0.0D);
            this.botplayer.moveUp();
        } else {
            setY(getY());
            this.botplayer.moveUp();
            if (getRotate() != 0.0D)
                setRotate(0.0D);
        }
    }

    public void moveLeft() {
        this.botplayer.getPosition();
        if (this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() - 1) == '0' || this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() - 1) == '4') {
            setX(getX() - 33.0D);
            if (getRotate() != 270.0D)
                setRotate(270.0D);
            this.botplayer.moveLeft();
        } else {
            setX(getX());
            this.botplayer.moveLeft();
            if (getRotate() != 270.0D)
                setRotate(270.0D);
        }
    }

    public void moveRight() {
        this.botplayer.getPosition();
        if (this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() + 1) == '0' || this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() + 1) == '4') {
            setX(getX() + 33.0D);
            if (getRotate() != 90.0D)
                setRotate(90.0D);
            this.botplayer.moveRight();
        } else {
            setX(getX());
            this.botplayer.moveRight();
            if (getRotate() != 90.0D)
                setRotate(90.0D);
        }
    }

    public void findPlayer(MyPlayer player) {
        player.getPosition();
        this.botplayer.getPosition();
        System.out.println("player coordinates:" + player.position.getX() + "," + player.position.getY());
        System.out.println("botplayer coordinates:" + this.botplayer.position.getX() + "," + this.botplayer.position.getY());
        if ((player.position.getX() > this.botplayer.position.getX() && this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() + 1) == '0') || (player.position.getX() > this.botplayer.position.getX() && this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() + 1) == '4')) {
            moveRight();
        } else if ((player.position.getX() < this.botplayer.position.getX() && this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() - 1) == '0') || (player.position.getX() < this.botplayer.position.getX() && this.botplayer.map.getValueAt(this.botplayer.position.getY(), this.botplayer.position.getX() - 1) == '4')) {
            moveLeft();
        } else if ((player.position.getY() < this.botplayer.position.getY() && this.botplayer.map.getValueAt(this.botplayer.position.getY() - 1, this.botplayer.position.getX()) == '0') || (player.position.getY() < this.botplayer.position.getY() && this.botplayer.map.getValueAt(this.botplayer.position.getY() - 1, this.botplayer.position.getX()) == '4')) {
            moveUp();
        } else if ((player.position.getY() > this.botplayer.position.getY() && this.botplayer.map.getValueAt(this.botplayer.position.getY() + 1, this.botplayer.position.getX()) == '0') || (player.position.getY() > this.botplayer.position.getY() && this.botplayer.map.getValueAt(this.botplayer.position.getY() + 1, this.botplayer.position.getX()) == '4')) {
            moveDown();
        }
    }
}
