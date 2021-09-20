package ood.pattern.observable.example1;

import java.util.Observable;

public class WeatherData extends Observable {
    private float temerature;
    private float humidity;
    private float pressure;

    public WeatherData() { }

    private void measurementsChange() {
        setChanged();
        notifyObservers();
    }

}
