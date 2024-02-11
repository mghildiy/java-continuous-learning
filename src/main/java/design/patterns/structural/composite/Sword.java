package design.patterns.structural.composite;

public class Sword extends AnimatedObject{
    @Override
    public void rotate(double degree) {
        System.out.println("Sword rotating");
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Sword translating");
    }
}
