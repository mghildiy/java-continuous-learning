package design.patterns.structural.composite;

public class Tree extends AnimatedObject {
    @Override
    public void rotate(double degree) {
        System.out.println("Tree rotating");
        this.childObjects.forEach(obj -> obj.rotate(degree));
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Tree translating");
        this.childObjects.forEach(obj -> obj.translate(x, y));
    }
}
