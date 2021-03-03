package patterns.main;

import patterns.core.builder.SportCar;

public class BuilderTest {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("BMW")
                .setColor("black")
                .setMaxSpeed(180)
                .build();
        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getMaxSpeed());
    }
}
