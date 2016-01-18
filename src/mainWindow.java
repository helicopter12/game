//Title: 2D Java Spaceship Game
//Authors: Ryan St. John, John Thornton
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

    public static void main(String[] args){

        if (downloadBackgroundImage() && downloadShip() && downloadBullet() && downloadEnemyShip() && downloadPowerup() && downloadEnemyBullet()) {
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
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "dr");
            pan.getActionMap().put("dr", new keyBinding("dr"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "ds");
            pan.getActionMap().put("ds", new keyBinding("ds"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "da");
            pan.getActionMap().put("da", new keyBinding("da"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "dw");
            pan.getActionMap().put("dw", new keyBinding("dw"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "fire");
            pan.getActionMap().put("fire", new keyBinding("fire"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), "dfire");
            pan.getActionMap().put("dfire", new keyBinding("dfire"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "rocket");
            pan.getActionMap().put("rocket", new keyBinding("rocket"));
            pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0, true), "drocket");
            pan.getActionMap().put("drocket", new keyBinding("drocket"));
            f.getContentPane().add(pan);
            f.setVisible(true);

            while (showStartMenu) {
                f.repaint();
                localPlayer.moveLocalPlayer();
                enemyBots.addNewEnemyShip();
                powerups.addNewPowerup();
                sleepThread();
            }
        }
    }

    public static void sleepThread() {
        try {
            Thread.sleep(3);
        } catch (java.lang.Exception ex) {
            //Failure to sleep
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

    private static boolean downloadShip() {
        try {
            paintPanel.playerShip = ImageIO.read(new URL("http://elder.comlu.com/game/ship.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

    private static boolean downloadBullet() {
        try {
            paintPanel.bullet = ImageIO.read(new URL("http://elder.comlu.com/game/bullet.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

    private static boolean downloadEnemyShip() {
        try {
            paintPanel.enemyShip = ImageIO.read(new URL("http://elder.comlu.com/game/enemy.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

    private static boolean downloadPowerup() {
        try {
            paintPanel.powerupBox = ImageIO.read(new URL("http://elder.comlu.com/game/powerup.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

    private static boolean downloadEnemyBullet() {
        try {
            paintPanel.enemyBullet = ImageIO.read(new URL("http://elder.comlu.com/game/enemybullet.png"));
            return true;
        } catch (java.io.IOException ex) {
            return false;
        }
    }

}
