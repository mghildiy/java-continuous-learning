package design.patterns.behavioural.chainofresponsibility;

public interface CreateActor {

    void nextHandler(CreateActor handler);

    boolean shouldCreateActor();
}
