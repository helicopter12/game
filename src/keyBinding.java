import javax.swing.AbstractAction;
import java.awt.List;
import java.awt.event.ActionEvent;

public class keyBinding extends AbstractAction {
    private String cmd;
    public static List keysDown = new List();

    public keyBinding(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (cmd.equalsIgnoreCase("enter")) {
            mainWindow.showStartMenu = false;
            System.exit(0);
        }else if (cmd.equalsIgnoreCase("fire")) {
            if (!listContains("fire")) {
                keysDown.add("fire");
            }
        }else if (cmd.equalsIgnoreCase("rocket")) {
            if (!listContains("rocket")) {
                keysDown.add("rocket");
            }
        }else if (cmd.equalsIgnoreCase("w")){
            if (!listContains("w")) {
                keysDown.add("w");
            }
        }else if (cmd.equalsIgnoreCase("a")) {
            if (!listContains("a")) {
                keysDown.add("a");
            }
        }else if (cmd.equalsIgnoreCase("s")) {
            if (!listContains("s")) {
                keysDown.add("s");
            }
        }else if (cmd.equalsIgnoreCase("d")) {
            if (!listContains("d")) {
                keysDown.add("d");
            }
        }else if (cmd.equalsIgnoreCase("dr")) {
            if (listContains("d")) {
                keysDown.remove("d");
            }
        }else if (cmd.equalsIgnoreCase("ds")) {
            if (listContains("s")) {
                keysDown.remove("s");
            }
        }else if (cmd.equalsIgnoreCase("da")) {
            if (listContains("a")) {
                keysDown.remove("a");
            }
        }else if (cmd.equalsIgnoreCase("dw")) {
            if (listContains("w")) {
                keysDown.remove("w");
            }
        }else if (cmd.equalsIgnoreCase("dfire")) {
            if (listContains("fire")) {
                keysDown.remove("fire");
            }
        }else if (cmd.equalsIgnoreCase("drocket")) {
            if (listContains("rocket")) {
                keysDown.remove("rocket");
            }
        }
    }

    private boolean listContains(String check) {
        for (String Item : keysDown.getItems()) {
            if(check.equals(Item)){
                return true;
            }
        }
        return false;
    }

    public static String getKeysAsString() {
        String ret = "";

        for( String item : keysDown.getItems() ) {
            ret += item;
        }

        return ret;
    }
}
