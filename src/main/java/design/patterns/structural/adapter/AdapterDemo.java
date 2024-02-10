package design.patterns.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        WeatherRoom wr = new WeatherRoom(new WeatherServiceAdapter(new WeatherService()));
        wr.displayPressure(City.Berlin);
    }
}
