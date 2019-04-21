package concurrency.my;

import java.util.Arrays;

public class Two implements Runnable{
	private int n;
	
	public Two(int n) {
		this.n=n;
	}
	
	public void run() {
		Integer[] sequence=new Integer[n];
		Fibonacci gen=new Fibonacci();
		for(int i=0;i<n;i++) 
			sequence[i]=gen.next();
		System.out.println("sequence is:"+Arrays.toString(sequence));	
		
	}

	public static void main(String[] args) {
		for(int i=0;i<20;i++)
		new Thread(new Two(i)).start();

	}

}
