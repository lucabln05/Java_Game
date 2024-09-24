package TwoD_Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel {
    public static final String IMAGE_DIR = "images/";

    private final Dimension size = new Dimension(1180, 780);

    private ImageIcon backgroundImage;
    private final String[] backgroundImage = new String[]{
            //hier kokmmen die bilder aus dem image package rein
    }

    private boolean gameOver = false;
    private int tanksDestroyedVounter = 0;

    private Timer t;

    public GamePanel() {
        setFocusable(true);
        setPreferredSize(prefSize);

        initGame();
        startGame();
    }
    public  boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    private void initGame() {
        setBackgroundImage(1);
        createGameObjects();

        t = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOnTick();
            }
        });
    }
    private void createGameObjects() {
        //spielobject später
    }

    private void initPlayersTank() {
        //pla<er inintialisierung
    }

    public void setBackgroundImage(ImageIcon backgroundImage) {
        String imagePath = IMAGE_DIR + backgroundImage[imageNumber];
        URL imageURL = getClass().getResource(imagePath);
        backgroundImage = new ImageIcon(imageURL);
    }
    public void startGame(){
        t.start();
    }
    public void restartGame() {
        tanksDestroyedVounter = 0;
        setGameOver(false);
        createGameObjects();
        startGame();
    }
    private void endGame() {
        setGameOver(true);
        pauseGame();
    }
    private void doOnTick() {
        tanksDestroyedVounter++;
        if (tanksDestroyedVounter > 2015) endGame();

        repaint();
    }
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        backgroundImage.paintIcon(null,g, 0, 0);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
        g.setColor(Color.BLUE);
        g.drawString("Tanks destroyed: " + tanksDestroyedVounter, 22, prefSize.height);

        if (isGameOver()){
            g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("Game Over", prefSize.width/2-130, prefSize.height/5);

        }
    }
}
