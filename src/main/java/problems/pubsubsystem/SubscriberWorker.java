package problems.pubsubsystem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SubscriberWorker implements Runnable {

    private final Subscriber subscriber;
//    take() acquires a lock (ReentrantLock).
//    It checks if the queue is empty:
//    If yes: it waits using a Condition.await().
//    If no: it proceeds to remove and return the head of the queue.
//    When a producer calls put(), it signals the waiting consumer threads to resume using Condition.signal().
    private final BlockingQueue<Message> messageQueue;

    public SubscriberWorker(Subscriber subscriber) {
        this.subscriber = subscriber;
        this.messageQueue = new LinkedBlockingQueue<>();
    }

    public void enqueue(Message message) throws InterruptedException {
        messageQueue.put(message);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // blocks if empty
                Message message = messageQueue.take();
                subscriber.consume(message);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
