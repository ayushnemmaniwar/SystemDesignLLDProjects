package PubSubSystem.Manager;

import PubSubSystem.Entity.Message;
import PubSubSystem.Entity.Subscribers;

import java.util.HashMap;
import java.util.Map;

public class SubscriberManager {
    Map<String, Subscribers> subscribersMap;

    public SubscriberManager() {
        subscribersMap = new HashMap<>();
    }

    public void addSubscriber(Subscribers s1) {
        subscribersMap.put(s1.getId(),s1);
    }

    public void deleteSubscriber() {

    }

    public void notification(Subscribers subscribers, Message message) {
        Subscribers subscribers1 = subscribersMap.get(subscribers.getId());
        System.out.println(subscribers1.getName() + "Received" + message.getTitle());
    }
}
