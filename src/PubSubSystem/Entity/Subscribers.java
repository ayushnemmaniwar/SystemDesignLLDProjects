package PubSubSystem.Entity;

import java.util.ArrayList;
import java.util.List;

public class Subscribers {
    String id;
    String name;
    List<Topic> topicList;

    public Subscribers(String id, String name) {
        this.id = id;
        this.name = name;
        topicList = new ArrayList<>();
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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
