package fusion.defaults;

import edu.wpi.first.wpilibj.command.Command;
import fusion.Fusion;


/**
 * FusionCommand
 * An extended class that writes the states of the command to Network Tables
 * 
 * @author Brendan F.
 * @author Bryce
 */
class FusionCommand extends Command {
    public FusionCommand() {}
    private int _id;
    @Override
    protected void initialize() {
    	this._id = Fusion.getInstance().command().init(this.getName(), this.getSubsystem());
    	this.init();
    }
    @Override
    protected void end() {
    	Fusion.getInstance().command().end(this.getName(), this.getSubsystem(), this._id);
    	this.stop();
    }
    @Override
    protected void interrupted() {
    	this.end();
    }
    public boolean isFinished() {
        return false;
    }
    /**
     * Initilization of the command
     */
    protected void init() {}
    /**
     * Ending of the command
     */
    protected void stop() {}
}
