package com.team2337.fusion.commands.auton;

import com.team2337.fusion.commands.auton.Wait;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Action is a command group, but with addWait because its nice
 * 
 * @author Brendan (2337)
 */
public class Action extends CommandGroup {
	
	public boolean color;

	public void addWait(double time) {
		super.addSequential(new Wait(time), (time + 1));
	}	
}