package design.patterns.structural.bridge.weapons;

public class BoomingGun implements  Weapon{
    @Override
    public void refill() {
        System.out.println("Booms added");
    }

    @Override
    public void attack() {
        System.out.println("Boom Boom Boom!");
    }
}
