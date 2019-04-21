package concurrency.eleven;

//The conditions, which always must hold are the following:
//1. If the tank is EMPTY then the current_load == 0
//2. If the tank is LOADED then the current_load >= 0
public class Tank {
	enum State{EMPTY,LOADED}
	
	private State state;
	private int current_load=0;
	
	public void validate() {
		if((state==State.EMPTY&&current_load!=0)||(state==State.LOADED&&current_load==0)) {
			throw new IllegalStateException();
		}
	}
	
	public void fill() {
		state=State.LOADED;
		Thread.yield();
		current_load=10;
	}
	
	public void drain() {
		state=State.EMPTY;
		Thread.yield();
		current_load=0;
	}

}
