package patterns.core.builder;

import lombok.Setter;

@Setter
public class Car {
    int seats;
    int engine;
    String gps;
    String tripComputer;

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", engine=" + engine +
                ", gps='" + gps + '\'' +
                ", tripComputer='" + tripComputer + '\'' +
                '}';
    }
}
