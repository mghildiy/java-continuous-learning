package design.patterns.behavioural.observer;

public class ConcreteSubscriber1 implements Subscriber {

    private String name;

    ConcreteSubscriber1(String name) {
        this.name = name;
    }
    @Override
    public void notify(Event event) {
        System.out.println(this.name + " notified");
        System.out.println(event.getMessage());
    }
}
