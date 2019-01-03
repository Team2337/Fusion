```java
package com.team2337.fusion.defaults;
import edu.wpi.first.wpilibj.command.Command;
import com.team2337.fusion.FusionCommandManager;
/**
 * 
 */
class FusionCommand extends Command {
    public FusionCommand() {}
    private int _id;
    @Override
    protected void initialize() {
    	this._id = Fusion.getInstance().commands().init(this.getName(), this.getSubsystem());
    	this.start();
    }
    @Override
    protected void end() {
    	Fusion.getInstance().end(this.getName(), _id);
    	this.stop();
    }
    @Override
    protected void interrupted() {
    	this.end();
    }
    protected void init() {}
    protected void stop() {}
}

```