package design.patterns.structural.adapter;

import org.apache.commons.math3.util.Pair;

import java.util.Random;

public class WeatherServiceAdapter implements PressureForCity {

    private WeatherService ws;

    WeatherServiceAdapter(WeatherService ws) {
        this.ws = ws;
    }
    @Override
    public double fetchPressure(City city) {
        Pair<Double, Double> location = cityToLatLong(city);
        return this.ws.airPressure(location.getFirst(), location.getSecond());
    }

    private Pair<Double, Double> cityToLatLong(City city) {
        Random rd =  new Random();
        return Pair.create(rd.nextDouble(180), rd.nextDouble(90));
    }
}
