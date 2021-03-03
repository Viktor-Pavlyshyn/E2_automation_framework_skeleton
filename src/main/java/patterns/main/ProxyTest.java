package patterns.main;

import patterns.core.Proxy.BMW;
import patterns.core.Proxy.Car;
import patterns.core.Proxy.ProxyCar;

public class ProxyTest {
    public static void main(String[] args) {
        Car bmv = new ProxyCar(new BMW());

        bmv.drive();
    }
}
