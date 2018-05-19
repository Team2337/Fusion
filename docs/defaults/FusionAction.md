# FusionAction
FusionAction is a **CommandGroup** but adds a new internal wait method. FusionAction is only meant to be used during **TELEOP**. For Autonomous look at  [Auto Action]()
## Features

With a normal command group you can **addSequential** or **addParallel** but wait about an **addWait**?
```java
class ExampleCommand extends FusionAction {
    public ExampleCommand() {
        //Do something
        this.addWait(10) //Adds wait for 10 seconds (double)
        //Do something else
    }
}
```

## Example
```java 
class ExampleCommand extends FusionAction {
    public ExampleCommand() {
        this.addSequential(new ResetPressure()) //Reset Claw Pressure 
        this.addWait(1) //Wait a second
        this.addSequential(new OpenClaw()) //Now lets open the claw to new pressure
    }
}

```