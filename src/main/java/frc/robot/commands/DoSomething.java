package frc.robot.commands;

import fusion.defaults.FusionAction;
/**
 * This does something, (it just waits)
 * 
 * The Network Table entries can be viewed with outline viewer
 * Under: Fusion -> Commands. A list of commands will be shown.
 */
public class DoSomething extends FusionAction {
    public DoSomething() {
        addSequential(new Move(0, 0));
        addWait(10);
        addSequential(new Stop(0, 0));
        addWait(10);
    }
}
