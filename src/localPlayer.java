import java.awt.Point;

public class localPlayer {
    public static Point location = new Point (0,0);
    private static final int sensitivity = 1;

    public static void moveLocalPlayer()
    {
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

        if(keys.contains("fire")){
            if(ammo.type.NORMAl.readyToFire()) {
                Point pt = new Point((paintPanel.playerShip.getWidth(null) + location.x) - 60, (paintPanel.playerShip.getHeight(null) / 2) + location.y);
                ammo bullet = new ammo(ammo.type.NORMAl, pt);
                ammo.fired.add(bullet);
            }
        }
    }
}
