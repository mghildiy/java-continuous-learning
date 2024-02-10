package design.patterns.creational.singleton.enumbased;

// threadsafe, sage from reflection and serialization-deserialization hacks
// note: field values of enum dont get deserialized, so we loss field values if instance is deserialized
public enum Universe {
    INSTANCE;

    private long age;
    private long numBodies;

    public void setAge(long age) {
        this.age = age;
    }

    public void setNumBodies(long numBodies) {
        this.numBodies = numBodies;
    }

    public long getAge() {
        return age;
    }

    public long getNumBodies() {
        return numBodies;
    }

    public long findUniverseWeight() {
        return numBodies * 1000;
    }
}
