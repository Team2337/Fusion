package com.team2337.fusion.management.auton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @see RobotMap
 */
public abstract class AutoCommand extends Command {
    private int _id;
	public AutoCommand() {}
    @Override
    protected void initialize() {
    	this._id = AutoCommandManager.getInstance().init(this.getName());
    	this.start();
    }
    @Override
    protected void end() {
    	AutoCommandManager.getInstance().end(this.getName(), _id);
    	this.stop();
    }
    @Override
    protected void interrupted() {
    	this.end();
    }
    protected void init() {}
    protected void stop() {}
}