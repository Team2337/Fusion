# FusionTimedRobot
FusionTimedRobot is a class that extends the orginal *TimedRobot* class. It uses a custom *FusionRobotBase* to call the new methods
## New Methods

During any initalization state: disabled, teleop, and auton this will run. It will **not** run during robotInit though.
```java
@Override
public void allInit() {
    //Do stuff here
}

```
Sometimes the need of updating NetworkTables are needed, so will allPeriodic youn can run something during **any** state of the robot. Keep in mind *robotPerodic*
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
	public void allInit() {
    	//Runs at any point a robot state is init'd (excecpt for robotInit())
    }
    public void allPeroidic() {
    	//Runs during any state, forever, every 20ms
    }
}

```