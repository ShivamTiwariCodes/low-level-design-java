package problems.pubsubsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {

    private final ConcurrentHashMap<String, Topic> topics;

    public Broker() {
        this.topics = new ConcurrentHashMap<>();
    }

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName,  new Topic());
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        topic.subscribe(subscriber);
    }

    public void publish(String topicName, String message) {
        Topic topic = topics.get(topicName);
        topic.publish(message);
    }

    public void stop() {
        for(Map.Entry<String, Topic> e: topics.entrySet()) {
            e.getValue().stop();
        }
    }


}
