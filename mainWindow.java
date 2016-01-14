//Title: 2D Java Spaceship Game
//Authors: Ryan St. John, John Thornto
//Date: 1/14/16

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;

public class mainWindow extends JFrame implements MouseListener, KeyListener {
    private static Image backgroundImage;
    public static  boolean switchy = true;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JComponent pan = new paintPanel();
        f.setTitle("Test");
        f.setSize(500,500);
        f.setLocation(25,25);
        f.setResizable(true);
        pan.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), "enter");
        pan.getActionMap().put("enter", new keyBinding("enter"));
        f.getContentPane().add(pan);
        f.setVisible(true);

        while(switchy){
            f.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent m) {

    }

    @Override
    public void mouseReleased(MouseEvent m) {

    }

    @Override
    public void mousePressed(MouseEvent m) {

    }

    @Override
    public void mouseEntered(MouseEvent m) {

    }

    @Override
    public void mouseExited(MouseEvent m) {

    }

    @Override
    public void keyPressed(KeyEvent k) {
        if (k.getKeyCode() == KeyEvent.VK_ENTER){
            switchy = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent k) {

    }

    @Override
    public void keyReleased(KeyEvent k) {

    }
}
