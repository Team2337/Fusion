package fusion.tools;

import fusion.defaults.FusionCommand;

/**
 * Wait command for anything
 * 
 * @author Brendan F.
 */
public class FusedWait extends FusionCommand {
    // Default time to timeout between commands (in seconds)
    private double time = 10;

    /**
     * A timeout command for CommandGroups
     * 
     * @param time Amount of time to wait between commands (in seconds)
     */
    public FusedWait(double time) {
        this.time = time;
    }

    // Sets the timeout
    protected void init() {
        // System.out.println("COMMAND TIMED OUT FOR:" + this.time + "seconds...");
        setTimeout(this.time);
    }

    // When the timeout ends, this command ends
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // When the timeout has ended, say so and end the command
    protected void stop() {
        System.out.println("TIMEOUT ENDED");
    }
}