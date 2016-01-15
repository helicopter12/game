//Title: 2D Java Spaceship Game
//Authors: Ryan St. John, John Thornto
//Date: 1/14/16

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.net.URL;

public class mainWindow extends JFrame{
    public static boolean showStartMenu = true;
    public static final int maxWidth = 1000;
    public static final int maxHeight = 500;

    public static void main(String[] args) {

        if (downloadBackgroundImage() && downloadship()) {
            JFrame f = new JFrame();
            JComponent pan = new paintPanel();
            f.setTitle("Test");
            f.setSize(maxWidth, maxHeight);
            f.setResizable(false);
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
            pan.getActionMap().put("enter", new keyBinding("enter"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "w");
            pan.getActionMap().put("w", new keyBinding("w"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "a");
            pan.getActionMap().put("a", new keyBinding("a"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "s");
            pan.getActionMap().put("s", new keyBinding("s"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "d");
            pan.getActionMap().put("d", new keyBinding("d"));
            f.getContentPane().add(pan);
            f.setVisible(true);

            while (showStartMenu) {
                f.repaint();
            }
        }
    }

    private static boolean downloadBackgroundImage() {
        try {
            paintPanel.backgroundImage = ImageIO.read(new URL("http://elder.comlu.com/game/space.jpg"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

    private static boolean downloadship() {
        try {
            paintPanel.playerShip = ImageIO.read(new URL("http://elder.comlu.com/game/ship.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }
}
