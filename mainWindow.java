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

        if (downloadBackgroundImage()) {
            JFrame f = new JFrame();
            JComponent pan = new paintPanel();
            f.setTitle("Test");
            f.setSize(maxWidth, maxHeight);
            f.setResizable(false);
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
            pan.getActionMap().put("enter", new keyBinding("enter"));
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
}
