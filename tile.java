package fifteen;

import java.awt.Color;
import java.awt.Polygon;

public class tile extends Polygon{

    private int x = 0, y = 0;
    private int tileNum = 0;
    private Color color;


    public tile(int x, int y, int num, Color c) {
        this.x = x;
        this.y = y;
        this.tileNum = num;
        this.color = c;

    }

    @Override
    public boolean contains(int x, int y){
        return contains(x, y);
    }

    public void setColor(Color c) {
        this.color = c;

    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTileNum() {
        return tileNum;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
