package fifteen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public final class fifteenPanel extends JPanel implements MouseListener {

    private final ArrayList<tile> tiles;
    private final ArrayList<tile> tilesCopy;
    private final int difficulty = 1000;
    private final int width = 100;
    private final int heigth = 100;
    private boolean iswon;
    private int clickX;
    private int clickY;
    private tile clickedTile;
    private tile blankTile;

    public fifteenPanel() {
        tiles = new ArrayList<>();
        tilesCopy = new ArrayList<>();
        int x = 0;
        int y = 0;
        addMouseListener(this);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                x = j;
                y = i;
                if (i == 3 && j == 3) {
                    tiles.add(new tile(x, y, 0, Color.WHITE));
                    tilesCopy.add(new tile(x, y, 0, Color.WHITE));
                    blankTile = tiles.get(15);
                } else {
                    tiles.add(new tile(x, y, 4 * i + 1 + j, new Color(x * 50, y * 50, x * y * 30)));
                    tilesCopy.add(new tile(x, y, 4 * i + 1 + j, new Color(x * 50, y * 50, x * y * 30)));
                }
            }
        }
        restartTiles();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!(iswon)) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            tiles.stream().map((t) -> {
                if (t.getTileNum() != 0) {
                    g.setColor(t.getColor());
                } else {
                    g.setColor(Color.WHITE);
                }
                return t;
            }).map((t) -> {
                g.drawRect(t.getX() * 100, t.getY() * 100, width, heigth);
                return t;
            }).map((t) -> {
                g.fillRect(t.getX() * 100, t.getY() * 100, width, heigth);
                return t;
            }).forEachOrdered((t) -> {
                g.setFont(this.getFont());
                int x = ((t.getX() * 100) + 50);
                int y = ((t.getY() * 100) + 50);
                g.setColor(Color.WHITE);
                g.drawString(Integer.toString(t.getTileNum()), x, y);
            });
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);
            g.drawString("You Win!", 150, 200);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (tile t : tiles) {
            if (t.getX() == (int) (e.getX() / 100) && t.getY() == (int) (e.getY() / 100)) {
                clickedTile = t;
                break;
            }
        }
        if (isMovable()) {
            moveTiles();
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public boolean isMovable() {
        return clickedTile.getX() + 1 == blankTile.getX() && clickedTile.getY() == blankTile.getY() ||//case 1
                clickedTile.getX() == blankTile.getX() && clickedTile.getY() == blankTile.getY() + 1 ||//case 2
                clickedTile.getX() - 1 == blankTile.getX() && clickedTile.getY() == blankTile.getY() ||//case 3
                clickedTile.getX() == blankTile.getX() && clickedTile.getY() == blankTile.getY() - 1;

    }

    public void moveTiles() {
        checkWon();
        int x = clickedTile.getX();
        int y = clickedTile.getY();
        clickedTile.setX(blankTile.getX());
        clickedTile.setY(blankTile.getY());
        blankTile.setX(x);
        blankTile.setY(y);
        checkWon();
    }

    public void restartTiles() {
        for (int i = 0; i < difficulty; i++) {
            int chance = (int) (Math.random() * 16);
            clickedTile = tiles.get(chance);
            while (!(isMovable())) {
                chance = (int) (Math.random() * 16);
                clickedTile = tiles.get(chance);
            }
            moveTiles();
            repaint();
        }
    }

    public void checkWon() {
        int numCorrect = 0;
        for (int i = 0; i < 16; i++) {
            if (tiles.get(i).getX() == tilesCopy.get(i).getX()
                    && tiles.get(i).getY() == tilesCopy.get(i).getY()) {
                numCorrect++;
            }
        }
        iswon = numCorrect == 16;
    }

    public boolean getWin(){
        return iswon;
    }
}
