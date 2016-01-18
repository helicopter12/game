import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class powerups {
    public Point location = new Point (0,0);
    public static java.util.List<powerups> powerBoxes = new ArrayList<powerups>();
    private static final int speed = 1;
    private static long cooldown;
    private static final long powerupRespawnTime = 10000;


    public powerups(Point location){
        this.location = location;
    }

    public static void drawPowerups(Graphics g) {
        //Stepping backwards removes a modified exception that is normally thrown
        for (int i = powerBoxes.size() - 1; i > -1; i--) {
            powerups box = powerBoxes.get(i);
            box.location.x = box.location.x - speed;
            g.drawImage(paintPanel.powerupBox,box.location.x, box.location.y, null);
            if (box.location.x < -(paintPanel.powerupBox.getWidth(null) )) {
                powerBoxes.remove(box);
            }
        }
    }

    public static void applyUpgrade() {
        Random rndMath = new Random();
        int rnd = rndMath.nextInt(6); //should output 0-5 (bound is exclusive?)

        switch (rnd) {
            case 0:
                //Give local player 2x speed for 15seconds (Handled under localplaye.moveLocalPlayer)
                localPlayer.sensitivity = 2;
                localPlayer.speedTimer = System.currentTimeMillis() + 15000;
                break;
            case 1:
                localPlayer.secondaryAmmoType = ammo.type.HEAT_SEAKING;
                localPlayer.gunTimerSecondary = System.currentTimeMillis() + 20000;
                break;
            case 2:
                localPlayer.primaryAmmoType = ammo.type.MACHINE_GUN;
                localPlayer.gunTimerPrimary = System.currentTimeMillis() + 10000;
                break;
            case 3:
                localPlayer.primaryAmmoType = ammo.type.LASER;
                localPlayer.gunTimerPrimary = System.currentTimeMillis() + 10000;
                break;
            case 4:
                localPlayer.secondaryAmmoType = ammo.type.ROCKET;
                localPlayer.gunTimerSecondary = System.currentTimeMillis() + 10000;
                break;
            case 5:
                //SHEILD POWERUP
                break;
        }
    }


    public static void addNewPowerup() {
        if(cooldown == 0 || cooldown <= System.currentTimeMillis()) {
            Random rnd = new Random();
            Point pt = new Point(mainWindow.maxWidth, rnd.nextInt(mainWindow.maxHeight - paintPanel.powerupBox.getHeight(null)));
            powerups box = new powerups(pt);
            powerBoxes.add(box);
            cooldown = System.currentTimeMillis() + powerupRespawnTime;
        }
        checkCollisions();
    }

    public static void checkCollisions() {
        for (int i = powerBoxes.size() - 1; i > -1; i--) {
            powerups box = powerBoxes.get(i);
            for (int j = ammo.fired.size() - 1; j > -1; j--){
                ammo bullet = ammo.fired.get(j);

                if((bullet.location.x >= box.location.x) && bullet.location.x <= (box.location.x + paintPanel.powerupBox.getWidth(null)) && (bullet.location.y >= box.location.y) && (bullet.location.y <= box.location.y + paintPanel.powerupBox.getHeight(null))){
                    powerBoxes.remove(box);
                    ammo.fired.remove(bullet);
                    applyUpgrade();
                }
            }
        }
    }
}
