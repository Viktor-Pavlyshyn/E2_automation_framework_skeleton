package patterns.main;

import patterns.core.observer.Subject;
import patterns.core.observer.WeatherStation;
import patterns.core.observer.observersimpl.AlertSystem;
import patterns.core.observer.observersimpl.Logger;
import patterns.core.observer.observersimpl.UserInterface;

public class ObserverTest {
    public static void main(String[] args) {

        Subject subject = new WeatherStation()
                .setTemperature(22)
                .setWindSpeed(5)
                .setPressure(2);

        Logger logger = new Logger(subject);
        AlertSystem alertSystem = new AlertSystem(subject);
        UserInterface userInterface = new UserInterface(subject);

        subject.notifyObserver();

        subject.removeObserver(alertSystem);
        subject.notifyObserver();
    }
}
