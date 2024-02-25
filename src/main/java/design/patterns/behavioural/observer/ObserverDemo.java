package design.patterns.behavioural.observer;

public class ObserverDemo {

    public static void main(String[] args) throws InterruptedException {
        ConcretePublisher publisher = new ConcretePublisher();
        Subscriber s1 = new ConcreteSubscriber1("Subscriber 1");
        Subscriber s2 = new ConcreteSubscriber2("Subscriber 2");
        Subscriber s3 = new ConcreteSubscriber1("Subscriber 3");
        publisher.subscribe(s1);
        publisher.subscribe(s2);
        publisher.subscribe(s3);
        publisher.awesomeBusinesslogic();
        System.out.println("*****Unsubscribe 3rd subscriber*****");
        publisher.unsubscribe(s3);
        publisher.awesomeBusinesslogic();
    }
}
