package design.patterns.creational.singleton.traditional;

public class SingletonDemo {
    public static void main(String[] args) {
        Universe univ = Universe.getUniverse(10000000000L, 100000000000000000L);
    }
}
