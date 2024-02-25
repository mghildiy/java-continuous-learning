package design.patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcretePublisher implements Publisher {

    List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    void awesomeBusinesslogic() throws InterruptedException {
        Thread.sleep(1000);
        notifySubscribers();
    }

    private void notifySubscribers() {
        Event someImportantEvent = new Event("Something very important happened");
        this.subscribers.forEach(s -> s.notify(someImportantEvent));
    }
}
