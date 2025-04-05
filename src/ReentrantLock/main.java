package ReentrantLock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Shared Resource with ReentrantLock
class SharedResource {
    private Queue<Integer> queue;
    private int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public SharedResource(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>();
    }

    public void produce(int item) throws InterruptedException {
        lock.lock();  // Acquire the lock
        try {
            while (queue.size() == capacity) { // Wait if queue is full
                System.out.println(Thread.currentThread().getName() + " waiting (Queue Full)...");
                notFull.await();
            }
            queue.add(item);
            System.out.println(Thread.currentThread().getName() + " produced: " + item);
            notEmpty.signal(); // Notify a waiting consumer
        } finally {
            lock.unlock(); // Release the lock
        }
        Thread.sleep(100); // Simulate work
    }

    public void consume() throws InterruptedException {
        lock.lock();  // Acquire the lock
        try {
            while (queue.isEmpty()) { // Wait if queue is empty
                System.out.println(Thread.currentThread().getName() + " waiting (Queue Empty)...");
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println(Thread.currentThread().getName() + " consumed: " + item);
            notFull.signal(); // Notify a waiting producer
        } finally {
            lock.unlock(); // Release the lock
        }
        Thread.sleep(100); // Simulate work
    }
}

// Producer Class
class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { // Each producer will produce 10 items
            try {
                sharedResource.produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Class
class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) { // Each consumer will consume 10 items
            try {
                sharedResource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(4); // Buffer capacity = 4

        // Creating multiple producers and consumers
        Thread producer1 = new Thread(new Producer(sharedResource), "Producer-1");
        Thread producer2 = new Thread(new Producer(sharedResource), "Producer-2");
        Thread consumer1 = new Thread(new Consumer(sharedResource), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(sharedResource), "Consumer-2");

        // Start all threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

//1️⃣ Why Use ReentrantLock?
//        It provides explicit locking mechanisms, preventing deadlocks.
//        Fine-grained control: We can use different condition variables for producers (notFull) and consumers (notEmpty).
//        More efficient than synchronized blocks in high-concurrency scenarios.
//        2️⃣ How Condition Variables Work?
//        notFull.await(): Makes a producer wait when the queue is full.
//        notEmpty.await(): Makes a consumer wait when the queue is empty.
//        notEmpty.signal(): Notifies a waiting consumer when an item is produced.
//        notFull.signal(): Notifies a waiting producer when space is available.


