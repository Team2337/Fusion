package fusion.tools;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Wait Command for Anything
 * 
 * @author Brendan F. (@ImportProgram)
 */
public class FusedWait extends Command {
    private double time = 10;
    
    public FusedWait(double time, String subsystem) {
    	this.time = time;
    }
    protected void init() {
    	setTimeout(this.time);
    }
    protected void execute() {
    	
    }
    protected boolean isFinished() { 
    	return isTimedOut();
    }
    protected void stop() {
 
    }
    protected void interrupted() {this.end();}
}