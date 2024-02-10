package design.patterns.creational.singleton.traditional;

// serialization-deserialization or use of reflection may break it
public class Universe {
    private static Universe universe = null;

    private long age;
    private long numBodies;

    private Universe(long age, long numBodies) {
        this.age = age;
        this.numBodies = numBodies;
    }

    // not thread safe
    public static Universe getUniverse(long age, long numBodies) {
        if(universe == null) {
            universe = new Universe(age, numBodies);
        }

        return universe;
    }

    public static synchronized Universe getUniverseThreadSafe(long age, long numBodies) {
        if(universe == null) {
            universe = new Universe(age, numBodies);
        }

        return universe;
    }
}
