package Tank_classes;

import Tank_classes.Map;
import Ideaone.Tank_classes.MyPlayer;
import Ideaone.Tank_classes.Position;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Tank extends ImageView {
    public Tank(MyPlayer player, Map map) {
        super("Ideaone/img/Tank-GTAA.png");
        Position position = player.getPosition();
        setX(position.getX() * 33.3D);
        setY(position.getY() * 33.3D);
        setFitWidth(30.0D);
        setFitHeight(40.0D);
        setOnKeyPressed(event -> {
            switch (null.$SwitchMap$javafx$scene$input$KeyCode[event.getCode().ordinal()]) {
                case 1:
                    player.getPosition();
                    System.out.println(map.getValueAt(player.position.getY() + 1, player.position.getX()));
                    if (map.getValueAt(player.position.getY() + 1, player.position.getX()) == '0' || map.getValueAt(player.position.getY() + 1, player.position.getX()) == '4') {
                        setY(getY() + 33.0D);
                        if (getRotate() != 180.0D)
                            setRotate(180.0D);
                        player.moveDown();
                        break;
                    }
                    setY(getY());
                    player.moveDown();
                    if (getRotate() != 180.0D)
                        setRotate(180.0D);
                    break;
                case 2:
                    player.getPosition();
                    System.out.println(map.getValueAt(player.position.getY() - 1, player.position.getX()));
                    if (map.getValueAt(player.position.getY() - 1, player.position.getX()) == '0' || map.getValueAt(player.position.getY() - 1, player.position.getX()) == '4') {
                        setY(getY() - 33.0D);
                        if (getRotate() != 0.0D)
                            setRotate(0.0D);
                        player.moveUp();
                        break;
                    }
                    setY(getY());
                    player.moveUp();
                    if (getRotate() != 0.0D)
                        setRotate(0.0D);
                    break;
                case 3:
                    player.getPosition();
                    System.out.println(map.getValueAt(player.position.getY(), player.position.getX() - 1));
                    if (map.getValueAt(player.position.getY(), player.position.getX() - 1) == '0' || map.getValueAt(player.position.getY(), player.position.getX() - 1) == '4') {
                        setX(getX() - 33.0D);
                        if (getRotate() != 270.0D)
                            setRotate(270.0D);
                        player.moveLeft();
                        break;
                    }
                    setX(getX());
                    player.moveLeft();
                    if (getRotate() != 270.0D)
                        setRotate(270.0D);
                    break;
                case 4:
                    player.getPosition();
                    System.out.println(map.getValueAt(player.position.getY(), player.position.getX() + 1));
                    if (map.getValueAt(player.position.getY(), player.position.getX() + 1) == '0' || map.getValueAt(player.position.getY(), player.position.getX() + 1) == '4') {
                        setX(getX() + 33.0D);
                        if (getRotate() != 90.0D)
                            setRotate(90.0D);
                        player.moveRight();
                        break;
                    }
                    setX(getX());
                    player.moveRight();
                    if (getRotate() != 90.0D)
                        setRotate(90.0D);
                    break;
            }
        });
    }
}
