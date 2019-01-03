package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import fusion.managment.controllers.types.XboxModule;

public class OI {
    public OI() {
        XboxModule driver = new XboxModule(1);
    }
}