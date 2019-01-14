package fusion.defaults;

import edu.wpi.first.wpilibj.command.CommandGroup;
import fusion.tools.FusedWait;

/**
 * Fuson Action
 * An action is a command group but adds wait built right in
 * Allows for faster and easier programming of timed events
 * No need for creating waits commands for each subsystem too
 * As required is not really needed by the Scheduler
 * 
 * @author Brendan F. (@ImportProgram)
 */
public class FusionAction extends CommandGroup {
    public FusionAction() {}
    /**
     * AddWait - Adds a wait thats sequential to other statments
     * @param time Time in a double format. In seconds.
     */
    public void addWait(double time) {
        addSequential(new FusedWait(time));
    }
}