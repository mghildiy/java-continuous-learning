package design.patterns.structural.adapter;

public class WeatherRoom {
    PressureForCity adapter;

    WeatherRoom(PressureForCity adapter) {
        this.adapter = adapter;
    }
    void displayPressure(City city) {
        System.out.println("*****Weather for city "+ city + " is *****");
        System.out.println(this.adapter.fetchPressure(city) + " units");
        System.out.println("******************************************");
    }
}
