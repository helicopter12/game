import java.awt.Point;

public class localPlayer {
    public static Point location = new Point (0,0);
    private static final int sensitivity = 1;

    public static void moveLocalPlayer()
    {
        final String keys = keyBinding.getKeysAsString();
        if(keys.contains("a")){
            location.x = location.x - sensitivity;
        }
        if(keys.contains("s")){
            location.y = location.y + sensitivity;
        }
        if(keys.contains("w")){
            location.y = location.y - sensitivity;
        }
        if(keys.contains("d")){
            location.x = location.x + sensitivity;
        }
    }
}
