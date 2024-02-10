package design.patterns.structural.builder;

public class Car {
    // mandatory features
    String wheels;
    String axle;
    String chassis;
    String engine;
    String fuelTank;

    // optional features
    String internet;
    String videogames;

    private Car(CarBuilder builder) {
        this.axle = builder.axle;
        this.chassis = builder.chassis;
        this.engine = builder.engine;
        this.fuelTank = builder.fuelTank;
        this.wheels = builder.wheels;
        this.internet = builder.internet;
        this.videogames = builder.videogames;
    }



    public static class CarBuilder {
        String wheels;
        String axle;
        String chassis;
        String engine;
        String fuelTank;

        // optional features
        String internet;
        String videogames;

        CarBuilder(String wheels, String axle, String fueltank, String chassis, String engine) {
            this.axle = axle;
            this.chassis = chassis;
            this.engine = engine;
            this.fuelTank = fueltank;
            this.wheels = wheels;
        }

        CarBuilder setInternet(String internet) {
            this.internet = internet;
            return this;
        }

        CarBuilder setVideogames(String videogames) {
            this.videogames = videogames;
            return this;
        }

        Car build() {
            return new Car(this);
        }
    }
}
