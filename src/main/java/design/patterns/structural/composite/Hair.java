package design.patterns.structural.composite;

public class Hair extends AnimatedObject {
    @Override
    public void rotate(double degree) {
        System.out.println("Hair rotating");
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Hair translating");
    }
}
