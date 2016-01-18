import java.awt.Point;

public class localPlayer {
    public static ammo.type primaryAmmoType = ammo.type.NORMAl;
    public static ammo.type secondaryAmmoType = ammo.type.BOMB;
    public static Point location = new Point (0,0);
    public static int score = 0;
    public static int sensitivity = 1;
    public static long speedTimer, gunTimerPrimary, gunTimerSecondary;

    public static void moveLocalPlayer()
    {
        //If they have the speed power up too long then return to normal speed (1x)
        if(sensitivity != 1) {
            if(speedTimer <= System.currentTimeMillis() || speedTimer == 0) {
                sensitivity = 1;
            }
        }

        final String keys = keyBinding.getKeysAsString();
        if(keys.contains("a")){
            if(location.x > 0) {
                location.x = location.x - sensitivity;
            }
        }
        if(keys.contains("s")){
            if((location.y + paintPanel.playerShip.getHeight(null)) < mainWindow.maxHeight + 50) {
                location.y = location.y + sensitivity;
            }
        }
        if(keys.contains("w")){
            if(location.y > -75) {
                location.y = location.y - sensitivity;
            }
        }
        if(keys.contains("d")){
            if(location.x + paintPanel.playerShip.getWidth(null) < mainWindow.maxWidth) {
                location.x = location.x + sensitivity;
            }
        }

        handleFiring(keys);
    }

    public static void handleFiring(String keys) {

        //Check if the powerup time is up for secondary weapons
        if ((secondaryAmmoType != ammo.type.BOMB) && (gunTimerSecondary== 0 || gunTimerSecondary <= System.currentTimeMillis())) {
            secondaryAmmoType = ammo.type.BOMB;
        }
        //Check if the powerup time is up for primary weapons
        if ((primaryAmmoType != ammo.type.NORMAl) && (gunTimerPrimary == 0 || gunTimerPrimary <= System.currentTimeMillis())) {
            primaryAmmoType = ammo.type.NORMAl;
        }

        if(keys.contains("fire")) {
            //Handle firing
            if (primaryAmmoType.readyToFire()) {
                Point pt = new Point((paintPanel.playerShip.getWidth(null) + location.x) - 60, (paintPanel.playerShip.getHeight(null) / 2) + location.y);
                ammo bullet = new ammo(primaryAmmoType, pt);
                ammo.fired.add(bullet);
            }
        }


        if (keys.contains("rocket")) {
            //Handle firing
            if (secondaryAmmoType.readyToFire()) {
                Point pt = new Point((paintPanel.playerShip.getWidth(null) + location.x) - 60, (paintPanel.playerShip.getHeight(null) / 2) + location.y);
                ammo bullet = new ammo(secondaryAmmoType, pt);
                ammo.fired.add(bullet);
            }
        }
    }
}
