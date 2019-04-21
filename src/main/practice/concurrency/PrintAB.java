/**
 * 
 */
package concurrency;

/**
 * @author lumia
 *
 */
public class PrintAB {
    private   final Object object = new Object();
    private  boolean flag = false;
    
    public static void main(String[] args) {
        PrintAB printA = new PrintAB();
        MyRunnable1 myRunnable1 = printA.new MyRunnable1();
        MyRunnable2 myRunnable2 = printA.new MyRunnable2();
        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        thread1.start();
        thread2.start();
    }
    
    public class MyRunnable1 implements Runnable {
        public void run() {
            while (true) {
                synchronized (object) {
                    if (flag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {

                        }
                    }
                    System.out.print('A');
                    flag = true;
                    object.notify();
                }
            }
        }
        }

        public class MyRunnable2 implements Runnable {
            public void run() {
                while (true) {
                    synchronized (object) {
                        if (!flag) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {

                            }
                        }
                        System.out.print('B');
                        flag = false;
                        object.notify();
                    }

                }
            }
        }

    }