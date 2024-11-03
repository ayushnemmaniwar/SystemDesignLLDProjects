package PubSubSystem.Entity;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String id;
    String name;

    List<Subscribers> subscribersList;

    public Topic(String id, String name) {
        this.id = id;
        this.name = name;
        this.subscribersList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subscribers> getSubscribersList() {
        return subscribersList;
    }

    public void setSubscribersList(List<Subscribers> subscribersList) {
        this.subscribersList = subscribersList;
    }
}
