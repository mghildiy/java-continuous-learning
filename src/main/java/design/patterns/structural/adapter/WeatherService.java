package design.patterns.structural.adapter;

import java.util.Random;

public class WeatherService {

    double airPressure(double latitude, double longitude) {
        return new Random().nextDouble(100.00);
    }
}
