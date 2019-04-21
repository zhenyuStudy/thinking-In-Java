package concurrency.eleven;

public class SafeTank extends Tank {
	
	public synchronized void validate() {
		super.validate();
	}
	
	public synchronized void fill() {
		super.fill();
	}
	
	public synchronized void drain() {
		super.drain();
	}
}
