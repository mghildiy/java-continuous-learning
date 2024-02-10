package design.patterns.creational.singleton.enumbased;

public class EnumSingletonDemo {

    public static void main(String[] args) {
        Universe univ = Universe.INSTANCE;
        univ.setAge(14242412L);
        System.out.println(univ.findUniverseWeight());
        if(univ.getAge() != 14242412L) {
            throw new RuntimeException("Not working as expected");
        }
    }
}
