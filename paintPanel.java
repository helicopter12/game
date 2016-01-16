import com.sun.org.apache.xpath.internal.operations.Gt;

import javax.swing.JComponent;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;

public class paintPanel extends JComponent {
    public static Image backgroundImage, playerShip;
    private double stepTick = 0;
    public double rocketSpeedPercent = 100;

    public void paint(Graphics g) {

        //Draw the moving background - (Need a background that can be repeated)
        g.drawImage((backgroundImage == null ? null : backgroundImage),(int)(stepTick <= (mainWindow.maxWidth - backgroundImage.getWidth(null)) ? stepTick = 0 : (stepTick = stepTick - ((rocketSpeedPercent/1000.0) * 5))), -10, null);

        //Draw the local player spaceship
        g.drawImage((playerShip == null ? null : playerShip), localPlayer.location.x, localPlayer.location.y, null);

        //Draw the start menu
        drawStartMenu(g);

        //Draw the keys down for debugging
        drawKeysDown(g);
    }

    public void drawStartMenu(Graphics g) {
        if (mainWindow.showStartMenu == true) {
            g.setColor(new Color(0,255,0,255));
            g.drawString("Space Ride v1.0", (mainWindow.maxWidth / 2) - 50, (mainWindow.maxHeight / 2) - 10);
            g.setColor(Color.white);
            g.drawString("Press 'Enter' to play",(mainWindow.maxWidth / 2) - 60, (mainWindow.maxHeight / 2) + 10);
        }
    }

    public void drawKeysDown(Graphics g) {
        if(keyBinding.keysDown.toString() != null) {
            int i = 20;
            for (String member : keyBinding.keysDown.getItems()) {
                g.drawString(member, 10, i);
                i+=20;
            }
        }
    }
}
