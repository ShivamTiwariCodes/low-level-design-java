package problems.pubsubsystem;

public class PubSubSystemDemo {

    public static void run() {

        String topic1 = "topic-1";
        Broker broker1 = new Broker();

        broker1.createTopic(topic1);
        Subscriber subscriber1 = new Subscriber();
        Subscriber subscriber2 = new Subscriber();

        broker1.subscribe(topic1, subscriber1);
        broker1.subscribe(topic1, subscriber2);

        broker1.publish(topic1, "message-1");
        broker1.publish(topic1, "message-2");

        broker1.stop();

    }
}
