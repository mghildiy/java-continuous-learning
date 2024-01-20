package multithreading;

public abstract class Counter {
    int counter = 0;

    abstract void increment();
    abstract void decrement();
}
