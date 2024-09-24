package TwoD_Game;

//Game Window Imports
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
//Menu Bar imports
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
//Event listener Importe
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//GameWindows Listerer Importe

//
import java.awt.Graphics;
//WIndow event listerner importe
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    private Player player;

    public GameWindow() {


        JPanel testpanel = new JPanel();
        testpanel.setPreferredSize(new Dimension(600, 400));

        //Fügt den windows event listener ein
        registerWindowsListener();

        player = new Player(1, 1);
//Fügt die gamebar ein
        createMenu();

//Erstellt GameWindow
        add(testpanel);
        pack();

        setTitle("Game");
        setLocation(10, 10);
        setResizable(false);

        setVisible(true);
    }

    //Erstellung der Gamebar
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefGame = new JMenu("Preferences");

        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        menuBar.add(prefGame);

        addFileMenuItems(fileMenu);
    }

    //Fügt einen Unterreiter bei file ein
    private void addFileMenuItems(JMenu fileMenu) {
        JMenuItem quitGame = new JMenuItem("Quit Game");
        fileMenu.add(quitGame);

        //Eventlister für klich auf quit game
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            player.draw(g);
        }
    }

    //Erstellt ein windowslistener
    private void registerWindowsListener() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                //hier wird später das spiel wieder fortgesetzt
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //hier wird später das Spiel pausiert
            }
        });
    }
}
