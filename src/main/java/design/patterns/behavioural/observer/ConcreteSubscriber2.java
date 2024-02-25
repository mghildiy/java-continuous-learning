package design.patterns.behavioural.observer;

public class ConcreteSubscriber2 implements Subscriber {

    private String name;

    ConcreteSubscriber2(String name) {
        this.name = name;
    }
    @Override
    public void notify(Event event) {
        System.out.println(this.name + " notified");
        System.out.println(event.getMessage());
    }
}
