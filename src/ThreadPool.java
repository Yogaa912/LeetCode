import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
    	// creating a thread pools
        ExecutorService executor = Executors.newFixedThreadPool(3); // Thread pool with 3 threads
        /*
         * Using Executor Framework
         * */
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task.");
            });
        }

        executor.shutdown(); // Graceful shutdown of the thread pool
    } 
}
/*
 * 1. fixed thread pool
 * - a fixed number of threads
 * - Suitable for applications with a steady number of tasks.
 * ExecutorService executor = Executors.newFixedThreadPool(4);
 * 2. Cached Thread Pool
 * - Creates threads as needed but reuses previously created threads.
 * - Suitable for short-lived tasks.
 * ExecutorService executor = Executors.newCachedThreadPool();
 * 3. Single Thread Executor:
 * - A single worker thread to execute tasks sequentially.
 * ExecutorService executor = Executors.newSingleThreadExecutor();
 * 4. Scheduled Thread Pool
 * ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
	scheduler.scheduleAtFixedRate(() -> {
    System.out.println("Periodic Task");
	}, 0, 1, TimeUnit.SECONDS);
 * 
 * Lock Mechanisms
 * Locks are used to control access to shared resources in a multithreaded environment. They help prevent issues such as race conditions and data inconsistency.
 * Types of Locks
 * 1. Intrinsic Locks (Synchronized Keyword)
 * The simplest way to achieve synchronization.
 * Locks an object or a block of code.
 * 2. Explicit Locks (Lock Interface)
 * - Provides more control than synchronized.
 * - Part of java.util.concurrent.locks.
 * */
