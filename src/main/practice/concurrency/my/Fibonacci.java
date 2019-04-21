package concurrency.my;

import net.mindview.util.Generator;

public class Fibonacci implements Generator<Integer> {
	private int count=0;

	public Integer next() {return fib(count++);}

	private int fib(int n) {
		if (n < 2) return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci gen=new Fibonacci();
		System.out.println(gen.count);
		for(int i=0;i<25;i++) {
			System.out.print(gen.next()+" ");
		}
		System.out.println("\n"+gen.count);
	}
}
