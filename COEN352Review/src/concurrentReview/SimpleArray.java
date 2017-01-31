package concurrentReview;

import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray { // CAUTION: NOT THREAD SAFE!!
	private static final SecureRandom generator = new SecureRandom();
	private final int[] array;
	private int writeIndex = 0;
	
	public SimpleArray(int size) {
		array = new int[size];
	}
	
	//public void add(int value) {  -> refactor to be thread safe
	public synchronized void add(int value) {
		int position = writeIndex; // store the write index
		
		try {
			// put thread to sleep for 0-499 ms
			Thread.sleep(generator.nextInt(500));
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		// put value in the appropriate element
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.%n", 
				Thread.currentThread().getName(), value, position);
		
		++writeIndex;
		System.out.printf("Next write index: %d%n", writeIndex);
	}
	
	public String toString() {
		return Arrays.toString(array);
	}
}
