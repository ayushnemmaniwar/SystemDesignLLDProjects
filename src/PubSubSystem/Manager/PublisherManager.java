package PubSubSystem.Manager;

import PubSubSystem.Entity.Message;
import PubSubSystem.Entity.Publisher;
import PubSubSystem.Entity.Topic;

import java.util.HashMap;
import java.util.Map;

public class PublisherManager {
    Map<String, Publisher> publisherMap;

    public PublisherManager() {
        publisherMap = new HashMap<>();
    }

    public void addPublisher(Publisher publisher) {
        publisherMap.put(publisher.getId(),publisher);
    }
    public void deletePublisher(Publisher publisher) {

    }
    public void publishMessageToTopic(TopicManager topicManager,SubscriberManager subscriberManager, Topic topic, Message message) {
        topicManager.messageFromPublisher(topic,subscriberManager,message);
    }
}
