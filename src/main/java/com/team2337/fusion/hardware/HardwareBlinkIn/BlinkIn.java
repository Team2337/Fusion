package com.team2337.fusion.hardware.HardwareBlinkIn;

import edu.wpi.first.wpilibj.Spark;

public class BlinkIn {
	public static double OFF = 1.00;
	public static double BLUE = 0.97;
	public static double PURPLE = 0.96;
	public static double WHITE = 0.92;
	public static double PINK = 0.88;
	public static double GREEN = 0.75;
	public static double DARK_BLUE = 0.84;
	public static double AQUA = 0.83;
	public static double LIGHT_BLUE = 0.70;
	public static double YELLOW = 0.65;
	public static double RED = 0.61;


	private Spark blinkin;
	private double setColor = 0;
	public BlinkIn(int pwm) {
		blinkin = new Spark(pwm);
		blinkin.setSafetyEnabled(false); //Its not really a motor, it's safe, right?
	}
	/**
	 * Set the color of the BlinkIn
	 */
	public void setColor(double color) {
		if (color != setColor) {
			blinkin.set(color);
		}
	}
	/**
	 * ??
	 */
	public void flow() {
		blinkin.set(-1.02);
	}
}
