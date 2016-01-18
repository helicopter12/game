import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class powerups {
    public Point location = new Point (0,0);
    public static java.util.List<powerups> powerBoxes = new ArrayList<powerups>();
    private static final int speed = 1;
    private static long cooldown;
    private static final long powerupRespawnTime = 20000;

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
                }
            }
        }
    }
}
