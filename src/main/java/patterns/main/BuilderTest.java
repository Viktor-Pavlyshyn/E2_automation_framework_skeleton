package patterns.main;

import patterns.core.builder.Car;
import patterns.core.builder.CarBuilder;
import patterns.core.builder.Director;

public class BuilderTest {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        Director director = new Director();

        director.constructSportsCar(builder);
        Car car = builder.getResult();

        System.out.println(car.toString());
    }
}
