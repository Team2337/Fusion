package fusion.tools;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import java.util.HashMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Simple Auto Select using SendableChooser, allows for command to be assigned
 * with ID This allows for the command to be not scheduled before start of
 * auton, rather starting the command during autonInit()
 * 
 * TODO: Rename file ///////////
 * 
 * @author Brendan F.
 * @author Bryce G.
 * @author Jack E.
 * 
 *         Example: FusionAutoChooser autoChooser = new FusionAutoChooser();
 *         autoChooser.addDefault("Do Nothing", auto_doNothing);
 *         autoChooser.addObject("3 Cube Auto", auto_3CubeLong);
 *         autoChooser.runSelected() //Whatever is selected in Sendable Chooser,
 *         gets picked
 */
public class FusedAutoSelector {
    public SendableChooser<String> chooser = new SendableChooser<>();
    public HashMap<String, Command> commands = new HashMap<String, Command>();

    public FusedAutoSelector() {
    }

    /**
     * Add an entry to the list of choosable selection
     * 
     * @param name    The display name of the auton to be added
     * @param command The command to be used when that auton is selected
     */
    public void addObject(String name, Command command) {
        String id = name.toLowerCase().replaceAll(" ", "_");
        chooser.addOption(name, id);
        commands.put(id, command);
    }

    /**
     * Sets the default command selection ///////////////Same exact code as above
     * function
     * 
     * @param name    Name of the selected object
     * @param command Command object
     */
    public void addDefault(String name, Command command) {
        String id = name.toLowerCase().replaceAll(" ", "_");
        chooser.addOption(name, id);
        commands.put(id, command);
    }

    /**
     * Runs the selected auton command
     */
    public void runSelected() {
        String id = chooser.getSelected();
        Command cmd = commands.get(id);
        cmd.start();
    }

    /**
     * Get the selected command and returns it
     * 
     * @return Command || FusionCommand || CommandGroup || FusionAction
     */
    public Command getSelected() {
        String id = chooser.getSelected();
        Command cmd = commands.get(id);
        return cmd;
    }
}