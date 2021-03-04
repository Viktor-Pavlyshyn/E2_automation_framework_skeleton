package patterns.core.proxy;

public class ProxyCar implements Car {
    Car car;

    public ProxyCar(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        System.out.println("setup car");
        car.drive();
    }
}
