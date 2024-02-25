package design.patterns.behavioural.observer;

public class Event {

    private String message;

    Event(String message) {
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }
}
