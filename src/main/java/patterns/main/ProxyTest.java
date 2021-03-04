package patterns.main;

import patterns.core.proxy.BMW;
import patterns.core.proxy.Car;
import patterns.core.proxy.ProxyCar;

public class ProxyTest {
    public static void main(String[] args) {
        Car bmv = new ProxyCar(new BMW());

        bmv.drive();
    }
}
