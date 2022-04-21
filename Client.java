import Ideaone.Client;
import Ideaone.Client_Tank_classes.Animation;
import Ideaone.Client_Tank_classes.BotTank;
import Ideaone.Client_Tank_classes.Botplayer;
import Ideaone.Client_Tank_classes.Brick;
import Ideaone.Client_Tank_classes.Bullet;
import Ideaone.Client_Tank_classes.Game;
import Ideaone.Client_Tank_classes.Map;
import Ideaone.Client_Tank_classes.Metall;
import Ideaone.Client_Tank_classes.MyPlayer;
import Ideaone.Client_Tank_classes.Player;
import Ideaone.Client_Tank_classes.Tank;
import Ideaone.Client_Tank_classes.Tree;
import Ideaone.Client_Tank_classes.Water;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Client extends Application {
    DataOutputStream toServer = null;

    DataInputStream fromServer = null;

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
        Botplayer botplayer = new Botplayer();
        game.addPlayer((Player) botplayer);
        BotTank botTank = new BotTank(botplayer);
        pane.getChildren().addAll((Object[]) new Node[]{(Node) tank, (Node) botTank});
        ArrayList<Bullet> bullets = new ArrayList<>();
        int count = 0;
        Scene scene = new Scene((Parent) pane, 500.0D, 500.0D);
        scene.setFill((Paint) Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CLIENT");
        primaryStage.show();
        tank.requestFocus();
        try {
            Socket socket = new Socket("localhost", 8000);
            this.fromServer = new DataInputStream(socket.getInputStream());
            this.toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            DataOutputStream finalToServer = this.toServer;
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
                    try {
                        finalToServer.writeUTF("fire");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    try {
                        finalToServer.writeUTF("right");
                        finalToServer.writeInt(player.position.getX());
                        finalToServer.writeInt(player.position.getY());
                        System.out.println("+ player.position.getX() + ", " + player.position.getY());
                                botTank.findPlayer(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getCode() == KeyCode.LEFT) {
                    try {
                        finalToServer.writeUTF("left");
                        finalToServer.writeInt(player.position.getX());
                        finalToServer.writeInt(player.position.getY());
                        System.out.println("+ player.position.getX() + ", " + player.position.getY());
                                botTank.findPlayer(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getCode() == KeyCode.UP) {
                    try {
                        finalToServer.writeUTF("up");
                        finalToServer.writeInt(player.position.getX());
                        finalToServer.writeInt(player.position.getY());
                        System.out.println("+ player.position.getX() + ", " + player.position.getY());
                                botTank.findPlayer(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getCode() == KeyCode.DOWN) {
                    try {
                        finalToServer.writeUTF("down");
                        finalToServer.writeInt(player.position.getX());
                        finalToServer.writeInt(player.position.getY());
                        System.out.println("+ player.position.getX() + ", " + player.position.getY());
                                botTank.findPlayer(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void sendData(DataOutputStream dataOutputStream, int x) throws IOException {
        dataOutputStream.writeInt(x);
    }
}
