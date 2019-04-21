package concurrency.atomicity;

public class SerialNumberGenerator {
//	CircularSet set = new CircularSet(33);
	private static volatile int serialNumber = 0;
	public synchronized static int nextSerialNumber() {
		return serialNumber++;
	}
}
