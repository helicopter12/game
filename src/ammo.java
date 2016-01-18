import java.awt.Point;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class ammo {
    public type ammoType;
    public Point location = new Point(0,0);
    public Image ammoImage;
    public static List<ammo> fired = new ArrayList<ammo>();
    private static int speed = 3;

    public enum type {
        NORMAl      (3,     500,     paintPanel.bullet),
        MACHINE_GUN (5,     100,     paintPanel.enemyBullet), //Image files need to be updated
        ROCKET      (1,     5000,    paintPanel.enemyBullet),
        HEAT_SEAKING(1,     5000,    paintPanel.enemyBullet),
        LASER       (10,    0,       paintPanel.enemyBullet),
        BOMB        (1,     4000,    paintPanel.enemyBullet);

        Image imgStyle;
        int speed;
        long cooldown, nextFire;

        type (final int speed, final long cooldown, final Image imgStyle){
            this.speed = speed;
            this.cooldown = cooldown;
            this.imgStyle = imgStyle;
        }

        public int getSpeed() { return speed; }
        public Image getImageStyle() { return  imgStyle; }
        public long getNextFire() { return nextFire; }

        public void updateCooldown() {
            nextFire = System.currentTimeMillis() + cooldown;
        }

        public boolean readyToFire() {
            if(nextFire <= System.currentTimeMillis() || nextFire == 0) {
                updateCooldown();
                return true;
            }
            return false;
        }
    }

    public ammo (type style, Point p) {
        this.location = p;
        this.speed = style.getSpeed();
        this.ammoImage = style.getImageStyle();
        this.ammoType = style;
    }

    public static void updateLocations(Graphics g) {
        //Stepping backwards removes a modified exception that is normally thrown
        for (int i = fired.size() - 1; i > -1; i--) {
            ammo shot = fired.get(i);

            if(shot.ammoType == type.NORMAl || shot.ammoType == type.MACHINE_GUN || shot.ammoType == type.LASER || shot.ammoType == type.ROCKET) {
                shot.location.x = shot.location.x + speed;
            }else if(shot.ammoType == type.BOMB) {
                shot.location.y = shot.location.y + speed;
            }else if(shot.ammoType == type.HEAT_SEAKING) {
                //Seeks the first enemy to the right - Can use index of 0 to get first to the left
                enemyBots bot =  enemyBots.enemies.get(enemyBots.enemies.size() - 1);
                if(bot != null){
                    if((bot.location.x + (paintPanel.enemyShip.getWidth(null) / 2)) > shot.location.x) {
                        shot.location.x = shot.location.x + speed;
                    }else{
                        shot.location.x = shot.location.x - speed;
                    }
                    if(bot.location.y + (paintPanel.enemyShip.getHeight(null) / 2)  > shot.location.y) {
                        shot.location.y = shot.location.y + speed;
                    }else{
                        shot.location.y = shot.location.y - speed;
                    }
                }
            }

            //Draw it
            g.drawImage(shot.ammoImage, shot.location.x, shot.location.y, null);

            //Check if it is out of bounds, if so remove it
            if (shot.location.x >= mainWindow.maxWidth) {
                fired.remove(shot);
            }else if( shot.location.y >= mainWindow.maxHeight){
                fired.remove(shot);
            }
        }
    }
}
