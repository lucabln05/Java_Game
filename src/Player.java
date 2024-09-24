import java.awt.Graphics;

public class Player {
    private int x, y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void draw(Graphics g){
        g.fillRect(x,y,1,1);
    }
}
