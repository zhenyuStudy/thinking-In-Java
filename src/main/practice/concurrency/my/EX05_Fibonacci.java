package concurrency.my;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EX05_Fibonacci implements Callable<Integer> {
	private int n;

	public EX05_Fibonacci(int n) {
		this.n = n;
	}

	public Integer call() throws Exception {
		Fibonacci gen = new Fibonacci();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + gen.next();
		}
		return sum;
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (int i = 1; i < 10; i++) {
			results.add(exec.submit(new EX05_Fibonacci(i)));
		}
		Thread.yield();
		exec.shutdown();
		for (Future<Integer> rs : results) {
			try {
				System.out.println(rs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
