package fusion.defaults;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * FusionCommandObject
 * 
 * Object to store time for a command
 * @author Brendan F.
 * @author Bryce G.
 */
public class FusionCommandObject {
	public LocalDateTime startTime;
	public LocalDateTime endTime;
	public FusionCommandObject() {
		startTime = LocalDateTime.now();
	}
	/**
	 * getStartEpoch - Gets the epoch (UTC) at the current time
	 * @return String [in miliseconds]
	 */
    public String getStartEpoch() {
        return String.valueOf(this.startTime.toInstant(ZoneOffset.UTC).getEpochSecond());
	}
	/**
	 * stopTime - Calcualte the time difference when the command is finsihed
	 */
	public void stopTime() {
		endTime = LocalDateTime.now();
	}
	/**
	 * Grabs the time
	 * @return Time [in seconds]
	 */
	public double getTime() {
		return Duration.between(startTime, endTime).getSeconds();
	}
}