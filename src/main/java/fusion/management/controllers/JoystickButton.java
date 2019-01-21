package fusion.management.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class JoystickButton extends Trigger {
    private final GenericHID m_joystick;
    private final int m_buttonNumber;

    /**
     * Create a joystick button for triggering commands.
     *
     * @param joystick     The GenericHID object that has the button (e.g. Joystick,
     *                     KinectStick, etc)
     * @param buttonNumber The button ID (see {@link GenericHID#getRawButton(int) })
     */
    public JoystickButton(GenericHID joystick, int buttonNumber) {
        m_joystick = joystick;
        m_buttonNumber = buttonNumber;
    }

    /**
     * Gets the value of the joystick button.
     *
     * @return The value of the joystick button (pressed/released)
     */
    public boolean get() {
        return m_joystick.getRawButton(m_buttonNumber);
    }

    /**
     * Starts the given command whenever the button is newly pressed.
     *
     * @param command The command to start
     */
    public void whenPressed(final Command command) {
        whenActive(command);
    }

    /**
     * Constantly starts the given command while the button is held.
     *
     * {@link Command#start()} will be called repeatedly while the button is held,
     * and will be canceled when the button is released.
     *
     * @param command The command to start
     */
    public void whileHeld(final Command command) {
        whileActive(command);
    }

    /**
     * Starts the command when the button is released.
     *
     * @param command The command to start
     */
    public void whenReleased(final Command command) {
        whenInactive(command);
    }

    /**
     * Toggles the command whenever the button is pressed (on then off, then on).
     *
     * @param command The command to toggle
     */
    public void toggleWhenPressed(final Command command) {
        toggleWhenActive(command);
    }

    /**
     * Cancel a command when the button is pressed.
     *
     * @param command The command to cancel
     */
    public void cancelWhenPressed(final Command command) {
        cancelWhenActive(command);
    }
}