package fusion.tools;

import fusion.defaults.FusionCommand;

/**
 * Wait command for anything
 * 
 * @author Brendan F. 
 */
public class FusedWait extends FusionCommand {
    private double time = 10;
    
    public FusedWait(double time) {
    	this.time = time;
    }

    protected void init() {
        System.out.println("INITED");
        System.out.println(this.time);
    	setTimeout(this.time);
    }
    protected void execute() {
    	
    }
    @Override
    protected boolean isFinished() { 
    	return isTimedOut();
    }
    protected void stop() {
        System.out.println("ENDED");

    }
    protected void interrupted() {this.end();}
}