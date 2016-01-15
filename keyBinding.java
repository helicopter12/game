import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class keyBinding extends AbstractAction {
    private final int sensitivity = 10;

    private String cmd;

    public keyBinding(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cmd.equalsIgnoreCase("enter")) {
            mainWindow.showStartMenu = false;
        }else if(cmd.equalsIgnoreCase("w")){
            localPlayer.location.y = localPlayer.location.y - sensitivity;
        }else if(cmd.equalsIgnoreCase("a")){
            localPlayer.location.x = localPlayer.location.x - sensitivity;
        }else if(cmd.equalsIgnoreCase("s")){
            localPlayer.location.y = localPlayer.location.y + sensitivity;
        }else if(cmd.equalsIgnoreCase("d")){
            localPlayer.location.x = localPlayer.location.x + sensitivity;
        }
    }
}
