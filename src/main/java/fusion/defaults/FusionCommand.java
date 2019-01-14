package fusion.defaults;

import edu.wpi.first.wpilibj.command.Command;
import fusion.Fusion;

/**
 * FusionCommand An extended class that writes the states of the command to
 * Network Tables
 * 
 * @author Brendan F.
 * @author Bryce
 */
public class FusionCommand extends Command {
    public FusionCommand() {
        super();
    }
    //Create a private integer to store the ID of this command
    private int _id;

    //Now we need to overide the initlize command that WPILib uses
    //Now the user needs to be using INIT for there "start up process"
    @Override
    protected void initialize() {
        this._id = Fusion.getInstance().command().init(this.getName(), this.getSubsystem());
        this.init();
    }

    @Override
    //Also the END process is overwritten. 
    //Now the user needs to use STOP for the "stopping of command"
    protected void end() {
        Fusion.getInstance().command().end(this.getName(), this.getSubsystem(), this._id);
        this.stop();
    }
    //Interrupted  & isFinished needs to be OVERIDDED in the extended class
    @Override
    protected void interrupted() {
        this.end();
    }
    @Override
    /**
     * Check if the command can be completed
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * Initilization of the command
     */
    protected void init() {
    }

    /**
     * Ending of the command
     */
    protected void stop() {
    }
}
