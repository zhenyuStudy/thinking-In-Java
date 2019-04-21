package concurrency.my;

public class LiftOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}

	}

	/*
	 * 1st practice
	 */
//	public static void main(String[] args) {
//		new LiftOff().run();
//		System.out.println("Waiting for LiftOff");
//	}
	/*
	 * 2nd practice
	 */
//	public static void main(String[] args) {
//		new Thread(new LiftOff()).start();
//		System.out.println("Waiting for LiftOff");
//	}
	/*
	 * 3rd practice
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
			System.out.println("Waiting for LiftOff");
		}
	}

}
