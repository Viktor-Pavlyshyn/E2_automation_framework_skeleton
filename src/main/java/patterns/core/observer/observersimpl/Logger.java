package patterns.core.observer.observersimpl;

import patterns.core.observer.Observer;
import patterns.core.observer.Subject;

public class Logger implements Observer {
    private int temperature;
    private int windSpeed;
    private int pressure;
    private Subject subject;

    public Logger(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(final int temperature, final int windSpeed, final int pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        log();
    }

    public void log() {
        System.out.println(String.format("%s have: temperature = %d, windSpeed = %d, pressure = %d.",
                this.getClass().getSimpleName(), temperature, windSpeed, pressure));
    }
}
