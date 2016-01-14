//Title: 2D Java Spaceship Game
//Authors: Ryan St. John, John Thornto
//Date: 1/14/16

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class mainWindow extends JFrame{
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
}
