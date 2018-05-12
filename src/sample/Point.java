package sample;

import java.util.Random;

public class Point {
    private int x;
    private int y;

    public Point(){ }

    public Point(int x, int y){
        set(x,y);
    }


    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

}
