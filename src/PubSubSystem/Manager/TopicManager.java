package PubSubSystem.Manager;

import PubSubSystem.Entity.Message;
import PubSubSystem.Entity.Subscribers;
import PubSubSystem.Entity.Topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicManager {
    Map<String, Topic> topicMap;


    public TopicManager() {
        topicMap = new HashMap<>();

    }

    public void addTopic(Topic t) {
        topicMap.put(t.getId(),t);
        //System.out.println(topicMap.size());
    }


    public void subscribe(Subscribers s,Topic t1) {
        Topic topic = topicMap.get(t1.getId());
        //System.out.println(topicMap.size());
        topic.getSubscribersList().add(s);

    }
    public void unSubscribe(Subscribers s,Topic t1) {
        Topic topic = topicMap.get(t1.getId());
        topic.getSubscribersList().remove(s);
    }

    public void messageFromPublisher(Topic topic,SubscriberManager subscriberManager, Message message) {
        notificationToSubscribers(topic,subscriberManager,message);

    }

    void notificationToSubscribers(Topic topic,SubscriberManager subscriberManager, Message message) {
        Topic topic1 = topicMap.get(topic.getId());
        List<Subscribers> subscribersList = topic1.getSubscribersList();
        for(Subscribers subscribers : subscribersList) {
            subscriberManager.notification(subscribers,message);
        }
    }
}
