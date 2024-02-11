package design.patterns.structural.composite;

public class Actor extends AnimatedObject{
    @Override
    public void rotate(double degree) {
        System.out.println("Human rotating");
        this.childObjects.forEach(obj -> obj.rotate(degree));
    }

    @Override
    public void translate(float x, float y) {
        System.out.println("Human translating");
        this.childObjects.forEach(obj -> obj.translate(x, y));
    }
}
