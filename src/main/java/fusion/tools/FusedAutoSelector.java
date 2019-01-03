package fusion.tools;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import java.util.HashMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Simple Auto Select using SendableChooser, allows for command to be assigned with ID
 * This allows for the command to be not scheudled before start of auton, rather starting
 * the command during autonInit
 * 
 * @author Brendan F.
 * @author Bryce G.
 * @author Jack E.
 * 
 * Example
 * FusionAutoChooser autochooser = new FusionAutoChooser()
 * autochooser.addDefault("Do Nothing", auto_doNothing) 
 * autochooser.addObject("3 Cube Auto", auto_3CubeLong)
 * autochooser.runSelected() //Whatever is seleted in Sendable Chooser, gets picked
 * TODO: Rename file
 */
public class FusedAutoSelector {
    public SendableChooser<String> chooser = new SendableChooser<>();
    public HashMap<String, Command> commands = new HashMap<String, Command>();
    public FusedAutoSelector() {}
    /**
     * Add an entry to the list of choosable selection
     * @param name
     * The display name of the auton to be added
     * @param command
     * The command to be used
     */
    public void addObject(String name, Command command) {
        String id = name.toLowerCase().replaceAll(" ", "_");
        chooser.addObject(name, id); //chooser.addObject("Cheesy Poofs 3 Cube", "cheesy_poofs_3_cube")
        commands.put(id, command);
    }

    /**
     * Sets the default command selection
     * @param name
     * Name of the selected object
     * @param command
     * Command object
     */
    public void addDefault(String name, Command command) {
        String id = name.toLowerCase().replaceAll(" ", "_");
        chooser.addDefault(name, id); //chooser.addObject("Cheesy Poofs 3 Cube", "cheesy_poofs_3_cube")
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
}