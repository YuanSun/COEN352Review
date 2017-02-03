package chap20.fibonacciCalculationConcurrent;
import java.time.Duration;
import java.time.Instant;

/**
 * This class sotores two Instants in time
 * @author sunyuan
 *
 */
public class TimeData {
	public Instant start;
	public Instant end;
	
	// return total time in seconds
	public double timeInSeconds() {
		return Duration.between(start, end).toMillis() / 1000.0;
	}
}
