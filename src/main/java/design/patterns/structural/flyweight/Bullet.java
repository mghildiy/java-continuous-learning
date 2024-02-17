package design.patterns.structural.flyweight;

public class Bullet extends Particle {

    Bullet(Sprite sprite) {
        this.sprite = sprite;
    }
    @Override
    void move() {
        System.out.println("Bullet moving");
    }

    @Override
    void draw() {
        System.out.println("Bullet drawing");
    }
}
