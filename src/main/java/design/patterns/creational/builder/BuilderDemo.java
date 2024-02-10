package design.patterns.creational.builder;

/*
creational design pattern that lets you construct complex objects step by step.
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("appolo",  "carbontype", "dieseltank", "widechassis", "mclaren")
                .setVideogames("mario")
                .setInternet("google")
                .build();
    }
}
