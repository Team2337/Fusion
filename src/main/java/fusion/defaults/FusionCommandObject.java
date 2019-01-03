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
    public String getStartEpoch() {
        return String.valueOf(this.startTime.toInstant(ZoneOffset.UTC).getEpochSecond());
    }
	public void stopTime() {
		endTime = LocalDateTime.now();
	}
	public double getTime() {
		return Duration.between(startTime, endTime).getSeconds();
	}
}