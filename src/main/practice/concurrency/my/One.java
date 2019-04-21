package concurrency.my;

public class One implements Runnable {
	private static int taskCount;
	private final int id = taskCount++;

	public One() {
		System.out.println("Thread start...,id=" + id);

	}


	public void run() {
		System.out.println("Stage" + id + ",message!");
		Thread.yield();
		System.out.println("Stage" + id + ",message!");
		Thread.yield();
		System.out.println("Stage" + id + ",message!");
		Thread.yield();
		System.out.println("Thread end...,id="+id);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new One()).start();
		}
	}
}
