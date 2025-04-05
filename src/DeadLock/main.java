package DeadLock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Producer Consumer SharedResource
class SharedResource {
    Queue<Integer> queue;
    int capacity;

    synchronized void produce(int item) throws InterruptedException {
        while (queue.size()==capacity) {
            System.out.println(Thread.currentThread().getName() + " waiting...");
            wait();
        }
        queue.add(item);
        System.out.println(Thread.currentThread().getName() + " produced: " + item);
        notifyAll();  // Notify the consumer that an item is available
        Thread.sleep(100);
    }

    synchronized void consume() throws InterruptedException {
        while (queue.size()==0) {
            System.out.println(Thread.currentThread().getName() + " waiting...");
            wait();
        }
        int item = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + item);
        notifyAll(); // Notify the producer that space is available
        Thread.sleep(100);
    }

    public SharedResource(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>();
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class Producer implements Runnable {
    SharedResource sharedResource;
    Lock lock = new ReentrantLock();

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=1;i<=20;i++) {
            try {
                sharedResource.produce(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable  {
    SharedResource sharedResource;
    Lock lock = new ReentrantLock();

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=1;i<=20;i++) {
            try {
                sharedResource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class main {
    public static void main(String []args) {
        SharedResource sharedResource = new SharedResource(4);
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        Thread thread1 = new Thread(producer,"Producer Thread");
        Thread thread2 = new Thread(consumer,"Consumer Thread");
        thread1.start();
        thread2.start();
    }
}
