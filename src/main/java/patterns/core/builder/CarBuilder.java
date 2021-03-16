package patterns.core.builder;

public class CarBuilder implements Builder{
    private Car car;

    public Car getResult() {
        return car;
    }

    @Override
    public void reset() {
        car = new Car();
    }

    @Override
    public void setSeats(int number) {
        car.setSeats(number);
    }

    @Override
    public void setEngine(int engine) {
        car.setEngine(engine);
    }

    @Override
    public void setTripComputer() {
        car.setTripComputer("TripComputer");
    }

    @Override
    public void setGPS() {
        car.setGps("GPS");
    }
}
