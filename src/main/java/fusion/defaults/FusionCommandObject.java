package fusion.defaults;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Object that stores the time for a command
 * 
 * @author Brendan F.
 * @author Bryce G.
 */
public class FusionCommandObject {

	// Variables for recording times
	public LocalDateTime startTime;
	public LocalDateTime endTime;

	/**
	 * Record the start time of the command automatically
	 */
	public FusionCommandObject() {
		startTime = LocalDateTime.now();
	}

	/**
	 * Gets the current UTC time (based on the Unix Epoch)
	 * 
	 * @return Time since the Unix Epoch (as a string) [in milliseconds]
	 */
	public String getStartEpoch() {
		return String.valueOf(this.startTime.toInstant(ZoneOffset.UTC).getEpochSecond());
	}

	/**
	 * Record the end time of the command
	 */
	public void stopTime() {
		endTime = LocalDateTime.now();
	}

	/**
	 * Gets the time
	 * 
	 * @return Time the command has run [in seconds]
	 */
	public double getTime() {
		return Duration.between(startTime, endTime).getSeconds();
	}
}