package com.team2337.fusion.commands.auton;
/**
 * 
 * TODO: Make this a normal wait (FusionCommand)
 *
 */
public class Wait extends AutoCommand {
	private double time = 10;
    public Wait(double time) {
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
