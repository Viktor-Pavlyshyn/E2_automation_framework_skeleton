package patterns.core.observer.observersimpl;

import patterns.core.observer.Observer;
import patterns.core.observer.Subject;

public class UserInterface implements Observer {
    private int temperature;
    private int windSpeed;
    private int pressure;
    private Subject subject;

    public UserInterface(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(final int temperature, final int windSpeed, final int pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println(String.format("%s have: temperature = %d, windSpeed = %d, pressure = %d.",
                this.getClass().getSimpleName(), temperature, windSpeed, pressure));
    }
}
