package design.patterns.behavioural.iterator;

public class IteratorDemo {

    public static void main(String[] args) {
        MyAweSomeTree<Integer> myTree=  new MyAweSomeTree<>(10);
        Iterator<Integer> iter = myTree.getIterator(MyAweSomeTree.IteratorType.BREADTH);
        iter.hasNext();
        iter.next();

        iter = myTree.getIterator(MyAweSomeTree.IteratorType.DEPTH);
        iter.hasNext();
        iter.next();
    }
}
