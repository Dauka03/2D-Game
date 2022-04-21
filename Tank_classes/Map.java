package Tank_classes;

import Ideaone.Tank_classes.InvalidMapException;

import java.util.Scanner;

public class Map {
    private char[][] map;

    private int N;

    public Map(Scanner in) throws InvalidMapException {
        this.N = in.nextInt();
        this.map = new char[this.N][this.N];
        if (this.N == 0)
            throw new InvalidMapException("Map size can not be zero");
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                this.map[i][j] = in.next().charAt(0);
                if (this.map[i][j] == 'L' || this.map[i][j] == 'R' || this.map[i][j] == 'U' || this.map[i][j] == 'D')
                    throw new InvalidMapException("Not enough map elements");
            }
        }
    }

    public Map() {
    }

    public int getSize() {
        return this.N;
    }

    public void setValueAt(int x, int y, char map2) {
        this.map[x][y] = map2;
    }

    public char getValueAt(int x, int y) {
        return this.map[x][y];
    }

    public void print() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++)
                System.out.print(getValueAt(i, j) + " ");
            System.out.println();
        }
    }
}
