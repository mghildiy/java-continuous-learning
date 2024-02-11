package design.patterns.structural.bridge.weapons;

public class Sword implements Weapon {
    @Override
    public void refill() {
        System.out.println("Sword sharpened");
    }

    @Override
    public void attack() {
        System.out.println("Slash Slash Slash!");
    }
}
