import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class keyBinding extends AbstractAction {

    private String cmd;

    public keyBinding(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cmd.equalsIgnoreCase("enter")) {
            mainWindow.switchy = false;
        }else{
            mainWindow.switchy = false;
        }
    }
}
