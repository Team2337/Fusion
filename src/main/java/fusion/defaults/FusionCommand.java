package fusion.defaults;

import edu.wpi.first.wpilibj.command.Command;
import fusion.Fusion;

/**
 * A standard WPI Command class with the addition of runtime tracking. A user
 * must use init() instead of initialize(), and stop() instead of end()
 * 
 * @author Brendan F.
 * @author Bryce
 */
public class FusionCommand extends Command {
    public FusionCommand() {
        super();
    }

    // Creates a private integer to store the ID of this command (can be used in the
    // user's code to access Fusion's NetworkTable entries)
    private int _id;

    /**
     * Instead of initialize(), the user uses init(), because initialize() is
     * dedicated to managing the time that the command started running
     */
    @Override
    protected void initialize() {
        this._id = Fusion.getInstance().command().init(this.getName(), this.getSubsystem());
        this.init();
    }

    /**
     * Instead of end(), the user uses stop(), because end() is dedicated to
     * managing the time that the command finished running
     */
    @Override
    protected void end() {
        Fusion.getInstance().command().end(this.getName(), this.getSubsystem(), this._id);
        this.stop();
    }

    // Both interrupted() and isFinished() cannot use @Override in the user's code /////Is this right?

    /**
     * Called if the command is cancelled/interrupted
     */
    @Override
    protected void interrupted() {
        this.end();
    }

    /**
     * Checks if the command meets it's end condition
     */
    @Override
    protected boolean isFinished() {
        // By default, the command never ends
        return false;
    }

    /**
     * The start of the command (is used by the user in place of initialize())
     */
    protected void init() {
    }

    /**
     * The end of the command (is used by the user in place of end())
     */
    protected void stop() {
    }
}
