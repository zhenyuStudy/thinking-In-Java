package concurrency.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luzhenyu
 *
 */
public class AThread implements Runnable {

	public int countDown = 3;
	private static int taskCount;
	private final int id=taskCount++;
	

	public AThread() {
		System.out.println("AThread Started, ID = " + id);
//		System.out.println("AThread End, ID = "+id);
	}

//	public static void main(String[] args) {
//		for(int i=0;i<5;i++) {
//			new Thread(new AThread()).start();
//		}
//	}

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++) {
			exec.execute(new AThread());
		}
	}
	
	public void run() {
		while (countDown-- > 0) {
			System.out.println("��ӡ��Ϣ, ID = "+id);
			Thread.yield();
		}
		System.out.println("AThread End, ID = "+id);
	}
}
