# Fusion

The **Fusion** library is a dynamic library that simplifies and overhauls the WPILib direct library. 

It improves, robot functionality, adds lots of support for NetworkTable entries, hardware support, and allows for hot swapping (using NetworkTables). 

## Installing

###### *GradleRIO...*

## Outline

The libary has four main categories. **Default, Hardware, Management and Tools**

##### **[Anything bold is extendable/instanceable below](#)**
##### [Anything not bold is an internal class that is used by Fusion](#)
---
#### Defaults
_Defaults is where main classes are- for Robot, Commands, and Subsystems._

- **[FusionTimedRobot](defaults/FusionTimedRobot/)** [TimedRobot Class]
- **[FusionCommand](defaults/FusionCommand)** [Command Class]
- **[FusionAction](defaults/FusionAction)** [CommandGroup Class]
- **[FusionSubsystem](defaults/FusionSubsystem)** [Subsystem Class]
- [FusionRobotBase](defaults/FusionRobotBase/)



---
#### Hardware
*Hardware is used for different sensors that don't have libraries, or need more features*

- HardwareBlinkin [Its a folder, but also the class created]
- HardwarePidgey (**TODO**: make it based on a Runnable not a Subsystem)

---
#### Management
*Management is where all managed based classes are. These include simplifying exisiting features (like AutoSelector) or etc*

- Controller - *Different Types of Controllers, with NT Hotswapping (or at least that's the goal)*
    - Types
        - **[ControllerXbox](management/controller/types/ControllerXbox/)**
    - [JoystickAnalogButton](management/controller/JoystickAnalogButton/)
    - [JoystickButton](management/controller/JoystickButton/)
    - [JoystickPOVButton](management/controller/JoystickPOVButton/)
    - [ControllerManager](management/controller/ControllerManager/)
- Drive - *Custom Drives based upon CTRE's TalonSRX and VictorSRX*
    - **[DriveFusion]()**
    - **[DriveDifferential]()**
- Auton
    - **[AutonAction](/wrappers/auto/AutoAction/)**
    - **[AutonCommand](/wrappers/auto/AutoCommand/)**
    - **[AutonSelector](/wrappers/auto/AutoSelector/)**
    - [AutonObject](/wrappers/auto/AutoObject/)**
    - [AutonWait](/wrappers/auto/AutoWait/)**
    - [AutonCommandManager](/wrappers/auto/AutoCommandManager/)
---
#### Tools
*Here's the tools. We like to fuse them together with the rest of the project*

- [FusedNT](tools/FusedNT/)
- [FusedRunnable](tools/FusedRunnable)
- [FusedCrashTracker](tools/CrashTracker)

---

## License

MIT

## Authors
This Project is developed for Team 2337 - The EngiNERDs

- [Brendan Fuller](http://github.com/Import-Python)

Also this project could have been done without:

 - WPILib
 - Cheesy Poofs
 - CTRE
 - ???




# Why

- FusionCommand gets created, gets added to the command manager. Now in theory, each "command" can only be used once at a time (unless no require is specified)
- Subsystem power usage needs to be track. How? I don't really know to be honest. 
    - Assign the motor an subsystem.id? (yea that would work, or just have a method to update the speed controllers?)
- "Stopping" subsystems?
- By where the command gets created from could be  different story (right?)

```java
class MyCustomLED implements CallbackLED {
    public void setLED(String color) {
        RobotMap.led.setColorViaString(color)
    }
} 
Fusion.getInstance().registerFeedbackLED(MyCustomLED, true, "MAIN") //class, default, name

```