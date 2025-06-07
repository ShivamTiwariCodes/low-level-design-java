package problems.pubsubsystem;

public class Subscriber {

    public void consume(Message message) {
        System.out.println("Consumed message is : " + message.getMessageContent() + " and thread name is : " +
                Thread.currentThread().getName());
    }
}
