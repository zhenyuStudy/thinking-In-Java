package concurrency.eleven;

import java.util.Random;

public class ConsistencyCheck implements Runnable{
	private static Random rnd=new Random();
	private Tank tank;
	
	ConsistencyCheck(Tank tank){
		this.tank=tank;
	}

	public void run() {
		for(;;) {
			if(rnd.nextBoolean()) {
				tank.fill();
			}else {
				tank.drain();
			}
			tank.validate();
		}
		
	}

}
