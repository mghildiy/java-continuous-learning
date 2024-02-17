package design.patterns.structural.flyweight;

public abstract class Particle {
    // heavy object(can be shared across objects)
    Sprite sprite;

    int x, y;

    abstract void move();
    abstract void draw();
}
