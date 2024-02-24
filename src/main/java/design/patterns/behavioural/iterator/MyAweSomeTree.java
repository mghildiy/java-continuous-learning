package design.patterns.behavioural.iterator;

public class MyAweSomeTree<T> implements Iterable<T> {

    Node<T> root;

    MyAweSomeTree(T value) {
        this.root = new Node(value);
    }

    void add(T node) {

    }

    @Override
    public Iterator<T> getIterator(IteratorType type) {
        if(type == IteratorType.BREADTH)
            return new BreadthFirstIterator(root);
        else return new DepthFirstIterator(root);
    }

    static enum IteratorType {
        DEPTH,
        BREADTH
    }

    static class Node<T> {
        T value;

        Node(T value) {
            this.value = value;
        }
        Node parent;
        Node left;
        Node right;
    }

    static class DepthFirstIterator<T> implements  Iterator<T> {

        Node root;
        Node current;

        DepthFirstIterator(Node root) {
            this.root = root;
        }

        @Override
        public boolean hasNext() {
            // logic to keep track of current node
            return false;
        }

        @Override
        public T next() {
            // logic to keep track of current node
            return null;
        }
    }

    static class BreadthFirstIterator<T> implements  Iterator<T> {

        Node root;
        Node current;

        BreadthFirstIterator(Node root) {
            this.root = root;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
