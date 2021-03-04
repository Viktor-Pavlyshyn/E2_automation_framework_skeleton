package patterns.core.builder;

public class Director {

    public void constructSportsCar(Builder builder){
        builder.reset();
        builder.setSeats(5);
        builder.setEngine(310);
        builder.setTripComputer();
        builder.setGPS();
    }
}
