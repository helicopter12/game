import javax.swing.JComponent;
import java.awt.*;

public class paintPanel extends JComponent {
    public static Image backgroundImage, playerShip, bullet, enemyShip, powerupBox, enemyBullet;
    private double stepTick = 0;
    public static double shipSpeedPercent = 100;

    public void paint(Graphics g) {

        //Draw the moving background - (Need a background that can be repeated)
        g.drawImage((backgroundImage == null ? null : backgroundImage),(int)(stepTick <= (mainWindow.maxWidth - backgroundImage.getWidth(null)) ? stepTick = 0 : (stepTick = stepTick - ((shipSpeedPercent/1000.0) * 5))), -10, null);

        //Draw enemies
        enemyBots.drawEnemies(g);

        //Draw Powerups
        powerups.drawPowerups(g);

        //Draw the local player spaceship
        g.drawImage((playerShip == null ? null : playerShip), localPlayer.location.x, localPlayer.location.y, null);

        //Draw the start menu
        drawStartMenu(g);

        //Draw bullets
        ammo.updateLocations(g);

        //Draw local HUD
        drawHUD(g);
    }

    public void drawHUD(Graphics g) {
        g.drawString("Score: " + localPlayer.score, 10, 20);
        g.drawString("Primary Gun (Spacebar): " + localPlayer.primaryAmmoType + "(" + ((localPlayer.primaryAmmoType.getNextFire() - System.currentTimeMillis()) >= 0 ? ((localPlayer.primaryAmmoType.getNextFire() - System.currentTimeMillis()) /1000) + 1 : "READY") + ")", 10, 40);
        g.drawString("Secondary Gun (F Key): " + localPlayer.secondaryAmmoType + "(" + ((localPlayer.secondaryAmmoType.getNextFire() - System.currentTimeMillis()) >= 0 ? ((localPlayer.secondaryAmmoType.getNextFire() - System.currentTimeMillis()) /1000) + 1 : "READY") + ")", 10, 60);
    }

    public void drawStartMenu(Graphics g) {
        if (mainWindow.showStartMenu == true) {
            g.setColor(new Color(0,255,0,255));
            g.drawString("Space Ride v1.0", (mainWindow.maxWidth / 2) - 50, (mainWindow.maxHeight / 2) - 10);
            g.setColor(Color.white);
            g.drawString("Press 'Enter' to play",(mainWindow.maxWidth / 2) - 60, (mainWindow.maxHeight / 2) + 10);
        }
    }

    //Debugging only
    public void drawKeysDown(Graphics g) {
        if(keyBinding.keysDown.toString() != null) {
            int i = 20;
            for (String member : keyBinding.keysDown.getItems()) {
                g.drawString(member, 10, i);
                i += 20;
            }
        }
    }
}
