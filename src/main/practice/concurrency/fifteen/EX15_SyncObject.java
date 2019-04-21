package concurrency.fifteen;

import static net.mindview.util.Print.*;

class SingleSynch {
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			print("f()");
			Thread.yield();
		}
	}

	public synchronized void g() {
		for (int i = 0; i < 5; i++) {
			print("g()");
			Thread.yield();
		}
	}

	public synchronized void h() {
		for (int i = 0; i < 5; i++) {
			print("h()");
			Thread.yield();
		}
	}
}

class TripleSynch {
	private Object syncObjectG = new Object();
	private Object syncObjectH = new Object();

	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			print("f()");
			Thread.yield();
		}
	}

	public void g() {
		synchronized (syncObjectG) {
			for (int i = 0; i < 5; i++) {
				print("g()");
				Thread.yield();
			}
		}
	}

	public void h() {
		synchronized (syncObjectH) {
			for (int i = 0; i < 5; i++) {
				print("h()");
				Thread.yield();
			}
		}
	}
}

public class EX15_SyncObject {
	public static void main(String[] args) throws Exception {
		final SingleSynch singleSynch = new SingleSynch();
		final TripleSynch tripleSynch = new TripleSynch();
		print("Test SingleSynch...");
		Thread t1 = new Thread() {
			public void run() {
				singleSynch.f();
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				singleSynch.g();
			}
		};
		t2.start();
		singleSynch.h();
		t1.join();
		t2.join();
		print("Test TripleSynch...");
		new Thread() {
			public void run() {
				tripleSynch.f();
			}
		}.start();
		new Thread() {
			public void run() {
				tripleSynch.g();
			}
		}.start();
		tripleSynch.h();
	}
}
