package producer_and_consumer;

public class SynchronizedBuffer implements Buffer {
	private int buffer = -1;
	private boolean occupied = false;
	
	public synchronized void blockingPut(int value) throws InterruptedException{
		while(occupied) {
			System.out.println("Producer tries to write.");
			displayState("Buffer full. Producer wait.");
			wait();
		}
		
		buffer = value;
		
		occupied = true;
		
		displayState("Producer writes " + buffer);
		
		notifyAll(); //telling waiting threads to entern runnable state
	}

	public synchronized int blockingGet() throws InterruptedException {
		while(!occupied) {
			System.out.println("Consumer tries to read.");
			displayState("Buffer empty. Consumer waits.");
			wait();
		}
		
		occupied = false;
		
		displayState("Consumer reads " + buffer);
		
		notifyAll();
		
		return buffer;
	}
	
	private synchronized void displayState(String string) {
		System.out.printf("%-40s%d\t\t%b%n%n", string, buffer, occupied);
		
	}
}
