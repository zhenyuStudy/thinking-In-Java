package concurrency.exercise;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;


class Coop1 implements Runnable {
    public Coop1() { print("Constructed Coop1"); }
    @Override
    public void run() {
        print("Coop1 going into wait");
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print("Coop1 exited wait");
    }
}

class Coop2 implements Runnable {
    Runnable otherTask;

    public Coop2(Runnable otherTask) {
        this.otherTask = otherTask;
        print("Constructed Coop2");
    }

    @Override
    public void run() {
        print("Coop2 pausing 5 seconds");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            print("Coop2 calling notifyAll");
            synchronized (otherTask) {
                otherTask.notifyAll();
            }
        }
    }
}


public class EX21_ThreadCooperation {
    public static void main(String[] args) {
        Runnable coop1 = new Coop1(), coop2 = new Coop2(coop1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(coop1);
        exec.execute(coop2);
        Thread.yield();
        exec.shutdown();
    }
}