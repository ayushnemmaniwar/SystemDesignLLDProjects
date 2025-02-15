package PubSubSystem;

import PubSubSystem.Entity.Message;
import PubSubSystem.Entity.Publisher;
import PubSubSystem.Entity.Subscribers;
import PubSubSystem.Entity.Topic;
import PubSubSystem.Manager.PublisherManager;
import PubSubSystem.Manager.SubscriberManager;
import PubSubSystem.Manager.TopicManager;

public class PubSubSystem {
    PublisherManager publisherManager;
    SubscriberManager subscriberManager;
    TopicManager topicManager;

     public PubSubSystem() {
         publisherManager = new PublisherManager();
         subscriberManager = new SubscriberManager();
         topicManager = new TopicManager();
    }
    public void start() {
        createDemoData();
    }

    private void createDemoData() {
         PubSubSystem pubSubSystem = new PubSubSystem();

        Message message1 = new Message("1","Iphone stock","Iphone stock is available");
        Message message2 = new Message("1","Android stock","Android stock is available");
        Message message3 = new Message("3","Books","Book stock is available");

        Publisher p1 = new Publisher("1","P1");
        Publisher p2 = new Publisher("2","P2");
        pubSubSystem.publisherManager.addPublisher(p1);
        pubSubSystem.publisherManager.addPublisher(p2);

        Topic t1 = new Topic("1","T1");
        Topic t2 = new Topic("2","T2");
        pubSubSystem.topicManager.addTopic(t1);
        pubSubSystem.topicManager.addTopic(t2);

        Subscribers s1 = new Subscribers("1","S1");
        Subscribers s2 = new Subscribers("2","S2");
        pubSubSystem.subscriberManager.addSubscriber(s1);
        pubSubSystem.subscriberManager.addSubscriber(s2);

        pubSubSystem.topicManager.subscribe(s1,t1);
        pubSubSystem.topicManager.subscribe(s1,t2);
        pubSubSystem.topicManager.subscribe(s2,t1);


        pubSubSystem.publisherManager.publishMessageToTopic(pubSubSystem.topicManager,pubSubSystem.subscriberManager,t1,message1);

        pubSubSystem.topicManager.unSubscribe(s1,t1);
        pubSubSystem.publisherManager.publishMessageToTopic(pubSubSystem.topicManager,pubSubSystem.subscriberManager,t1,message1);

    }
}
