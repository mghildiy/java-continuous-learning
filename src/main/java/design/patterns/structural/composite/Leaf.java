package design.patterns.structural.composite;

public class Leaf extends AnimatedObject {
    @Override
    public void rotate(double degree) {
        System.out.println("Leaf rotating");
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Leaf translating");
    }
}
