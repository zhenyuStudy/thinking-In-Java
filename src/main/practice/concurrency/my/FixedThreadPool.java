package concurrency.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool implements Runnable {

	public static void main(String[] args) {
		ExecutorService exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<7;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
