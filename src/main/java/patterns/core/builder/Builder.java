package patterns.core.builder;

public interface Builder {
    void reset();
    void setSeats(int number);
    void setEngine(int engine);
    void setTripComputer();
    void setGPS();
}
