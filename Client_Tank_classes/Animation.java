package Client_Tank_classes;

import Client_Tank_classes.Bullet;
import javafx.scene.layout.Pane;

public class Animation implements Runnable {
    Thread thread;

    Pane pane;

    Bullet bullet;

    public Animation(Pane pane, Bullet b) {
        this.pane = pane;
        this.bullet = b;
    }

    public void run() {
        while (this.bullet.getStatus() == true) {
            try {
                Thread.sleep(10L);
                this.bullet.fire(this.bullet);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start() {
        if (this.thread == null)
            this.thread = new Thread(this);
        this.thread.start();
    }
}
