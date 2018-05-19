package com.team2337.fusion.controller.xbox;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import com.team2337.fusion.controller.JoystickAnalogButton;
import com.team2337.fusion.controller.JoystickPOVButton;
import edu.wpi.first.wpilibj.Joystick;
/**
 * Define a Xbox Controller with all buttons
 * @author brendan@team2337.com
 *
 */
public class XboxModule {
    public JoystickButton A;
    public JoystickButton B;
    public JoystickButton X;
    public JoystickButton Y;
    public JoystickButton BUMPER_LEFT;
    public JoystickButton BUMPER_RIGHT;
    public JoystickButton BACK;
    public JoystickButton START;
    public JoystickButton STICK_LEFT;
    public JoystickButton STICK_RIGHT;
    public JoystickAnalogButton TRIGGER_RIGHT;
    public JoystickAnalogButton TRIGGER_LEFT;
    public JoystickPOVButton POV_UP;
    public JoystickPOVButton POV_UP_RIGHT;
    public JoystickPOVButton POV_RIGHT;
    public JoystickPOVButton POV_DOWN_RIGHT;
    public JoystickPOVButton POV_DOWN;
    public JoystickPOVButton POV_DOWN_LEFT;
    public JoystickPOVButton POV_LEFT;
    public JoystickPOVButton POV_UP_LEFT;
    public static Joystick joystick;

    public XboxModule(int id) {
        joystick = new Joystick(id);
        //get Type???????
        A = new JoystickButton(joystick, 1);
        B = new JoystickButton(joystick, 2);
        X = new JoystickButton(joystick, 3);
        Y = new JoystickButton(joystick, 4);
        BUMPER_LEFT = new JoystickButton(joystick, 5);
        BUMPER_RIGHT = new JoystickButton(joystick, 6);
        BACK = new JoystickButton(joystick, 7);
        START = new JoystickButton(joystick, 8);
        STICK_LEFT = new JoystickButton(joystick, 9);
        STICK_RIGHT = new JoystickButton(joystick, 10);
        TRIGGER_LEFT = new JoystickAnalogButton(joystick, 2);
        TRIGGER_RIGHT = new JoystickAnalogButton(joystick, 3);
        POV_UP = new JoystickPOVButton(joystick, 0);
        POV_UP_RIGHT = new JoystickPOVButton(joystick, 45);
        POV_RIGHT = new JoystickPOVButton(joystick, 90);
        POV_DOWN_RIGHT = new JoystickPOVButton(joystick, 135);
        POV_DOWN = new JoystickPOVButton(joystick, 180);
        POV_DOWN_LEFT = new JoystickPOVButton(joystick, 225);
        POV_LEFT = new JoystickPOVButton(joystick, 270);
        POV_UP_LEFT = new JoystickPOVButton(joystick, 315);
    }

}
