package patterns.core.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private int temperature;
    private int windSpeed;
    private int pressure;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(temperature, windSpeed, pressure));
    }

    public WeatherStation setTemperature(final int temperature) {
        this.temperature = temperature;
        notifyObserver();

        return this;
    }

    public WeatherStation setWindSpeed(final int windSpeed) {
        this.windSpeed = windSpeed;
        notifyObserver();

        return this;
    }

    public WeatherStation setPressure(final int pressure) {
        this.pressure = pressure;
        notifyObserver();

        return this;
    }
}
