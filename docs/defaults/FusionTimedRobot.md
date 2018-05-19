# FusionTimedRobot
FusionTimedRobot is a class that extends the orginal *TimedRobot* class. It uses a custom *FusionRobotBase* to call the new methods
## Features

During any initalization state: disabled, teleop, and auton this will run. It will **not** run during robotInit though.
```java
@Override
public void allInit() {
    //Do stuff here
}

```
Sometimes the need of updating NetworkTables are needed, so will allPeriodic youn can run something during **any** state of the robot. Keep in mind *robotPerodic* is still available  for use, just not recommended.
```java
@Override
public void allPeriodic() {
    //Do stuff here
}

```
## Example
```java 
class Robot extends FusionTimedRobot {
	/* Based on Timed Robot*/
    public void robotInit() {
        //Normal Robot Init, only gets called once and its NOT a state. Think of it as the constructor of the class.
    }

    /**
	 * Disabled State
	 */
	@Override
	public void disabledInit() {
		
	}
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    /**
	 * Autonomous State
	 */
	@Override
	public void autonomousInit() {

	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

    /**
	 * Teleop State
	 */
	@Override
	public void teleopInit() {
		
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Test State
	 */
	@Override
	public void testPeriodic() {
		
	}

    /**
	 * All States
	 */
	public void allInit() {
    	//Runs at any point a robot state is init'd (excecpt for robotInit())
    }
    public void allPeroidic() { //also you could use robotPeroidic() doesn't really matter
    	//Runs during any state, forever, every 20ms
    }
}

```