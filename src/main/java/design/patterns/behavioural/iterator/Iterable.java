package design.patterns.behavioural.iterator;

public interface Iterable<T> {

    Iterator<T> getIterator(MyAweSomeTree.IteratorType type);
}
