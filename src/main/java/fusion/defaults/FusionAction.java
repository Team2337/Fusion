package fusion.defaults;

import edu.wpi.first.wpilibj.command.CommandGroup;
import fusion.tools.FusedWait;

/**
 * An action is a command group, but it has a wait function built right in. This
 * allows for faster and easier programming of timed events with no need for
 * creating wait commands for each subsystem.
 * 
 * @author Brendan F. (@ImportProgram)
 */
public class FusionAction extends CommandGroup {
    public FusionAction() {
    }

    /**
     * Adds a wait that's sequential to other statements
     * 
     * @param time Time to wait (in seconds)
     */
    public void addWait(double time) {
        addSequential(new FusedWait(time));
    }
}