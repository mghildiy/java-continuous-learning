package design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class SceneGraph implements Movements {

    List<AnimatedObject> objects = new ArrayList<>();

    public void add(AnimatedObject object) {
        this.objects.add(object);
    }

    @Override
    public void rotate(double degree) {
        this.objects.forEach(obj -> obj.rotate(degree));
    }

    @Override
    public void translate(float x, float y) {
        this.objects.forEach(obj -> obj.translate(x, y));
    }
}
