package design.patterns.structural.composite;

public class CompositeDemo {

    public static void main(String[] args) {
        SceneGraph sg = new SceneGraph();
        AnimatedObject leaf = new Leaf();
        AnimatedObject leaf1 = new Leaf();
        AnimatedObject tree = new Tree();
        tree.add(leaf);
        tree.add(leaf1);
        sg.add(tree);
        AnimatedObject actor = new Actor();
        actor.add(new Hair());
        actor.add(new Cloth());
        actor.add(new Sword());
        sg.add(actor);

        sg.rotate(40);
    }
}
