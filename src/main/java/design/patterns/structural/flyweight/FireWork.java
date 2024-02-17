package design.patterns.structural.flyweight;

public class FireWork extends Particle {

    FireWork(Sprite sprite) {
        this.sprite = sprite;
    }
    @Override
    void move() {
        System.out.println("Firework moving");
    }

    @Override
    void draw() {
        System.out.println("Firework drawing");
    }
}
