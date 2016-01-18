import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class enemyBots {
    public Point location = new Point (0,0);
    public static List<enemyBots> enemies = new ArrayList<enemyBots>();
    private static final int speed = 1;
    private static long cooldown;
    private static final long enemyRespawnTime = 1700;

    public enemyBots(Point location){
        this.location = location;
    }

    public static void drawEnemies(Graphics g) {
        //Stepping backwards removes a modified exception that is normally thrown
        for (int i = enemies.size() - 1; i > -1; i--) {
            enemyBots enemy = enemies.get(i);
            enemy.location.x = enemy.location.x - speed;
            g.drawImage(paintPanel.enemyShip, enemy.location.x, enemy.location.y, null);
            if (enemy.location.x < -(paintPanel.enemyShip.getWidth(null) )) {
                enemies.remove(enemy);
            }
        }
    }

    public static void addNewEnemyShip() {
        if(cooldown == 0 || cooldown <= System.currentTimeMillis()) {
            Random rnd = new Random();
            Point pt = new Point(mainWindow.maxWidth, rnd.nextInt(mainWindow.maxHeight - paintPanel.enemyShip.getHeight(null)));
            enemyBots enemy = new enemyBots(pt);
            enemyBots.enemies.add(enemy);
            cooldown = System.currentTimeMillis() + enemyRespawnTime;
        }
        checkCollisions();
    }

    public static void checkCollisions() {
        for (int i = enemies.size() - 1; i > -1; i--) {
            enemyBots enemy = enemies.get(i);
            for (int j = ammo.fired.size() - 1; j > -1; j--){
                ammo bullet = ammo.fired.get(j);

                if((bullet.location.x >= enemy.location.x) && bullet.location.x <= (enemy.location.x + paintPanel.enemyShip.getWidth(null)) && (bullet.location.y >= enemy.location.y) && (bullet.location.y <= enemy.location.y + paintPanel.enemyShip.getHeight(null))){
                    enemies.remove(enemy);
                    ammo.fired.remove(bullet);
                    localPlayer.score += 100;
                }
            }
        }
    }
}
