package leetcode;
import java.util.concurrent.locks.*;

public class ExplicitLocks {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock(); // Always release the lock
        }
    }

    public static void main(String[] args) {
        ExplicitLocks example = new ExplicitLocks();

        Runnable task = example::increment;

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
