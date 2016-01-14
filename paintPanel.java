import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class paintPanel extends JComponent {
    Image backgroundImage;

    public void paint(Graphics g) {
        if(backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("C:\\Users\\Ryan\\Desktop\\Pics\\space.jpg"));
            } catch (java.io.IOException ex) {
            }
        }

        g.drawImage(backgroundImage, 0, -10, null);

        g.setColor(new Color(255,0,0,255));
        Random rnd = new Random();
        g.drawString("Press ENTER!!",rnd.nextInt(100), rnd.nextInt(100));
    }
}
