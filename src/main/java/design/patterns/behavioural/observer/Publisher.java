package design.patterns.behavioural.observer;

// observable
public interface Publisher {

    void subscribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);
}
