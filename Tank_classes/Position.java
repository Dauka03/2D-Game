package Tank_classes;

public class Position {
    private int x;

    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Ideaone.Tank_classes.Position p) {
        if (this.x == p.getX() && this.y == p.getY())
            return true;
        return false;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
