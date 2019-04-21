package concurrency.eleven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX11_Synchronized {
	public static void main(String[] args) {
//		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("Press Control-C to exit");
		ExecutorService exec=Executors.newCachedThreadPool();
		Tank tank=new SafeTank();
		for (int i = 0; i < 10; i++) {
			exec.execute(new ConsistencyCheck(tank));
		}
		Thread.yield();
		exec.shutdown();
	}
}
