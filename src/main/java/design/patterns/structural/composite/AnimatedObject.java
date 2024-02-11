package design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedObject implements Movements {
    List<AnimatedObject> childObjects = new ArrayList<>();

    void add(AnimatedObject child) {
        this.childObjects.add(child);
    }
}
