package com.team2337.fusion.defaults;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
class FusionCommand extends Command {
    public FusionCommand() {}
    private int _id;
    @Override
    protected void initialize() {
    	this._id = Fuson.getInstance().init(this.getName());
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

