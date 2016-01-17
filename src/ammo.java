import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public class ammo {
    public Point location = new Point(0,0);
    public static List<ammo> fired = new ArrayList<ammo>();
    private static int speed = 3;

    public enum type {
        NORMAl (3, 500), MACHINE_GUN(5, 100), ROCKET(1, 10000), HEAT_SEAKING(1, 20000), LASER(100, 0);

        int speed;
        long cooldown, nextFire;

        type (final int speed, long cooldown){
            this.speed = speed;
            this.cooldown = cooldown;
        }

        public int getSpeed() { return speed; }
        public long getCooldown() { return cooldown; }

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
        switch(style) {
            case NORMAl:
                this.location = p;
                speed = type.NORMAl.getSpeed();
                break;

            case MACHINE_GUN:
                break;

            case ROCKET:
                break;

            case HEAT_SEAKING:
                break;

            case LASER:
                break;

        }
    }

    public static void updateLocations(Graphics g) {
        //Stepping backwards removes a modified exception that is normally thrown
        for (int i = fired.size() - 1; i > -1; i--) {
            ammo shot = fired.get(i);
            shot.location.x = shot.location.x + speed;
            g.drawImage(paintPanel.bullet, shot.location.x, shot.location.y, null);
            if (shot.location.x >= mainWindow.maxWidth) {
                fired.remove(shot);
            }
        }
    }
}
