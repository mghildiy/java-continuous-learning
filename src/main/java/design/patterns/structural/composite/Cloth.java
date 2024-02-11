package design.patterns.structural.composite;

public class Cloth extends AnimatedObject {
    @Override
    public void rotate(double degree) {
        System.out.println("Cloth rotating");
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Cloth translating");
    }
}
