import Ideaone.Tank_classes.Animation;
import Ideaone.Tank_classes.BotPlayer;
import Ideaone.Tank_classes.BotTank;
import Ideaone.Tank_classes.Brick;
import Ideaone.Tank_classes.Bullet;
import Ideaone.Tank_classes.Game;
import Ideaone.Tank_classes.InvalidMapException;
import Ideaone.Tank_classes.Map;
import Ideaone.Tank_classes.Metall;
import Ideaone.Tank_classes.MyPlayer;
import Ideaone.Tank_classes.Player;
import Ideaone.Tank_classes.Tank;
import Ideaone.Tank_classes.Tree;
import Ideaone.Tank_classes.Water;
import Ideaone.xz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class xz extends Application {
    public static void main(String[] args) throws InvalidMapException {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scanner in = new Scanner(System.in);
        Map map = new Map(in);
        Game game = new Game(map);
        MyPlayer player = new MyPlayer();
        game.addPlayer((Player) player);
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (map.getValueAt(i, j) == '1') {
                    Metall wall = new Metall();
                    wall.setX(j * 33.3D);
                    wall.setY(i * 33.3D);
                    pane.getChildren().add(wall);
                } else if (map.getValueAt(i, j) == '2') {
                    Brick wall = new Brick();
                    wall.setX(j * 33.3D);
                    wall.setY(i * 33.3D);
                    pane.getChildren().add(wall);
                } else if (map.getValueAt(i, j) == '3') {
                    Water wall = new Water();
                    wall.setX(j * 33.3D);
                    wall.setY(i * 33.3D);
                    pane.getChildren().add(wall);
                } else if (map.getValueAt(i, j) == '4') {
                    Tree wall = new Tree();
                    wall.setX(j * 33.3D);
                    wall.setY(i * 33.3D);
                    pane.getChildren().add(wall);
                }
            }
        }
        Tank tank = new Tank(player, map);
        BotPlayer botplayer = new BotPlayer();
        game.addPlayer((Player) botplayer);
        BotTank botTank = new BotTank(botplayer);
        pane.getChildren().add(tank);
        pane.getChildren().add(botTank);
        ArrayList<Bullet> bullets = new ArrayList<>();
        int count = 0;
        Scene scene = new Scene((Parent) pane, 500.0D, 500.0D);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                System.out.println("BOOM");
                bullets.add(new Bullet(tank));
                pane.getChildren().add(bullets.get(bullets.size() - 1));
                try {
                    Animation animation = new Animation(pane, bullets.get(bullets.size() - 1));
                    animation.start();
                    bullets.remove(bullets.size() - 1);
                } catch (Exception ex) {
                    System.out.println("AAAAAA");
                }
            }
        });
        scene.setFill((Paint) Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
        tank.requestFocus();
        (new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(());
                Socket socket = serverSocket.accept();
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                int c = 0;
                while (true) {
                    c++;
                    player.getPosition();
                    System.out.println(c);
                    String dir = inputFromClient.readUTF();
                    if (dir.equals("right")) {
                        player.getPosition();
                        int x = inputFromClient.readInt();
                        int y = inputFromClient.readInt();
                        System.out.println("x,y:" + x + "," + y + "," + dir + "\n");
                        if (map.getValueAt(player.position.getY(), player.position.getX() + 1) == '0' || map.getValueAt(player.position.getY(), player.position.getX() + 1) == '4') {
                            tank.setX(tank.getX() + 33.0D);
                            if (tank.getRotate() != 90.0D)
                                tank.setRotate(90.0D);
                            player.moveRight();
                            botTank.findPlayer(player);
                            botplayer.getPosition();
                            continue;
                        }
                        tank.setX(tank.getX());
                        player.moveRight();
                        if (tank.getRotate() != 90.0D)
                            tank.setRotate(90.0D);
                        botTank.findPlayer(player);
                        continue;
                    }
                    if (dir.equals("fire")) {
                        System.out.println("BOOM");
                        bullets.add(new Bullet(tank));
                        pane.getChildren().add(bullets.get(bullets.size() - 1));
                        try {
                            Animation animation = new Animation(pane, bullets.get(bullets.size() - 1));
                            animation.start();
                            bullets.remove(bullets.size() - 1);
                        } catch (Exception ex) {
                            System.out.println("AAAAAA");
                        }
                        break;
                    }
                    if (dir.equals("left")) {
                        player.getPosition();
                        int x = inputFromClient.readInt();
                        int y = inputFromClient.readInt();
                        System.out.println("x,y:" + x + "," + y + "," + dir + "\n");
                        if (map.getValueAt(player.position.getY(), player.position.getX() - 1) == '0' || map.getValueAt(player.position.getY(), player.position.getX() - 1) == '4') {
                            tank.setX(tank.getX() - 33.0D);
                            if (tank.getRotate() != 270.0D)
                                tank.setRotate(270.0D);
                            player.moveLeft();
                            botTank.findPlayer(player);
                            continue;
                        }
                        tank.setX(tank.getX());
                        player.moveLeft();
                        if (tank.getRotate() != 270.0D)
                            tank.setRotate(270.0D);
                        botTank.findPlayer(player);
                        continue;
                    }
                    if (dir.equals("up")) {
                        player.getPosition();
                        int x = inputFromClient.readInt();
                        int y = inputFromClient.readInt();
                        System.out.println("x,y:" + x + "," + y + "," + dir + "\n");
                        if (map.getValueAt(player.position.getY() - 1, player.position.getX()) == '0' || map.getValueAt(player.position.getY() - 1, player.position.getX()) == '4') {
                            tank.setY(tank.getY() - 33.0D);
                            if (tank.getRotate() != 0.0D)
                                tank.setRotate(0.0D);
                            player.moveUp();
                            botTank.findPlayer(player);
                            continue;
                        }
                        tank.setY(tank.getY());
                        player.moveUp();
                        if (tank.getRotate() != 0.0D)
                            tank.setRotate(0.0D);
                        botTank.findPlayer(player);
                        continue;
                    }
                    if (dir.equals("down")) {
                        player.getPosition();
                        int x = inputFromClient.readInt();
                        int y = inputFromClient.readInt();
                        System.out.println("x,y:" + x + "," + y + "," + dir + "\n");
                        if (map.getValueAt(player.position.getY() + 1, player.position.getX()) == '0' || map.getValueAt(player.position.getY() + 1, player.position.getX()) == '4') {
                            tank.setY(tank.getY() + 33.0D);
                            if (tank.getRotate() != 180.0D)
                                tank.setRotate(180.0D);
                            player.moveDown();
                            botTank.findPlayer(player);
                            continue;
                        }
                        tank.setY(tank.getY());
                        player.moveDown();
                        if (tank.getRotate() != 180.0D)
                            tank.setRotate(180.0D);
                        botTank.findPlayer(player);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        })).start();
    }
}
