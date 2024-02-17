package design.patterns.behavioural.chainofresponsibility;

import java.util.Random;

public class WeappnChecker implements CreateActor {

    private CreateActor handler;

    private Random rnd = new Random();
    @Override
    public void nextHandler(CreateActor handler) {
        this.handler = handler;
    }

    @Override
    public boolean shouldCreateActor() {
        if(this.handler != null)
            return checkForWeapons() && this.handler.shouldCreateActor();
        else return checkForWeapons();
    }

    private boolean checkForWeapons() {
        System.out.println("Checking for team weapons");
        if(rnd.nextBoolean()) {
            return true;
        } else return false;
    }
}
