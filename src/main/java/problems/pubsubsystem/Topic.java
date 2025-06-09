package problems.pubsubsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// can be subscribed
public class Topic {

    private final int threadPoolSize = 10;
    private final List<SubscriberWorker> subscriberWorkers;

//    You submit a Runnable to the executor via submit() or execute().
//    Executor checks for an available thread in the pool:
//    1. If a thread is idle, it assigns the task to it.
//    2. If all threads are busy, the task goes into a queue (usually a BlockingQueue) to wait.
//    3. When a thread becomes free, it pulls a task from the queue and runs it.
//    4. The same thread is reused for future tasks (thread pooling = efficient).
    private final ExecutorService executor;


    public Topic() {
        subscriberWorkers = new ArrayList<>();
        executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void subscribe(Subscriber subscriber) {
        SubscriberWorker worker = new SubscriberWorker(subscriber);
        subscriberWorkers.add(worker);
        executor.submit(worker);
    }

    public void publish(String messageCotent) {
        Message message = new Message(messageCotent);
        for(SubscriberWorker worker: subscriberWorkers) {
            try {
                worker.enqueue(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        executor.shutdown();
    }
}
