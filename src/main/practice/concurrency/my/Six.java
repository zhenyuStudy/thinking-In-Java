package concurrency.my;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Six implements Runnable{
	private static Random rnd=new Random();
	private final Integer sleepTime=rnd.nextInt(10)+1; 


	public void run() {
		try {
			TimeUnit.SECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sleepTime);
	}

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
	    for(int i=0;i<10;i++) {
	    	exec.execute(new Six());
	    }
	    Thread.yield();
	    exec.shutdown();
	}
}	
