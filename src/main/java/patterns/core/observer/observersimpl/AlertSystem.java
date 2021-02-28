package patterns.core.observer.observersimpl;

import patterns.core.observer.Observer;
import patterns.core.observer.Subject;

public class AlertSystem implements Observer {
    private int temperature;
    private int windSpeed;
    private int pressure;
    private Subject subject;

    public AlertSystem(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int temperature, int windSpeed, int pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        alert();
    }

    public void alert() {
        System.out.println(String.format("%s have: temperature = %d, windSpeed = %d, pressure = %d.",
                this.getClass().getSimpleName(), temperature, windSpeed, pressure));
    }
}
