# FusionAction
FusionTimedRobot is a class that extends the orginal *TimedRobot* class. It uses a custom *FusionRobotBase* to call the new methods
## New Methods

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
class ExampleCommand extends FusionAction {

}

```