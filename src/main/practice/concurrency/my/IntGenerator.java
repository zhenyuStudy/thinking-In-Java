package concurrency.my;

public abstract class IntGenerator {
	private volatile boolean canceled=false; //用volitile保证了canceled变量的可见性。当多个竞争资源抢占该变量时，该变量的值只有唯一一份贡献，对其他抢占资源需是可见的。
	public abstract int next();
	public void cancel() {canceled=true;}
	public boolean isCanceled() {return canceled;}
}
