package concurrentReview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySumTest {
    private static ExecutorService tpool = Executors.newFixedThreadPool(20);
    private static final int upper = 14000;
    private static AtomicInteger total = new AtomicInteger(0);
    
	public static void main(String[] args) {
	    int ar[] = new int[upper];
	    for(int i = 1 ; i <= upper; i++){
	        ar[i-1]=i;
	    }

	    for(int i = 1 ; i <= ((upper%2) !=0 ? (upper-1):(upper)); i+=2){
	        final int a = ar[i-1];
	        final int b = ar[i];
	            Thread thread = new Thread(new Runnable(){
	                public void run() {
	                    int res = add(a, b);
	                    total.addAndGet(res);
	                    System.out.println("Current thread is " + Thread.currentThread().getName() + 
	                    		"; current total is " + total);
	                    return;
	            }});
	            tpool.execute(thread);
	    }
	    if(upper%2!=0)
	        total.addAndGet(ar[ar.length-1]);

	    tpool.shutdown(); //wait for everything to finish

	    try {
			boolean tasksEnded = tpool.awaitTermination(1, TimeUnit.MINUTES);
			
			if (tasksEnded) {
				System.out.println("Final result is " + total);
			} else {
				System.out.println("Timed out while waiting for tasks to finish.");
			}
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	    
		
	}
	
	private static int add(final int a, final int b){
	    return a+b;
	}

}
