package design.patterns.behavioural.chainofresponsibility;

import java.util.Random;

public class PowerChecker implements  CreateActor {

    private CreateActor handler;

    private Random rnd = new Random();
    @Override
    public void nextHandler(CreateActor handler) {
        this.handler = handler;
    }

    @Override
    public boolean shouldCreateActor() {
        if(this.handler != null)
            return checkForPower() && this.handler.shouldCreateActor();
        else return checkForPower();
    }

    private boolean checkForPower() {
        System.out.println("Checking for team power");
        if(rnd.nextBoolean()) {
            return true;
        } else return false;
    }
}
