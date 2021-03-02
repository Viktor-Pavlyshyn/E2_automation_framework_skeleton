package patterns.main;

import patterns.core.factorymethod.PizzaStore;
import patterns.core.factorymethod.storeimple.ChicagoStylePizzaStore;
import patterns.core.factorymethod.storeimple.NYStylePizzaStore;

public class FactoryMethodTest {
    public static void main(String[] args) {
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        chicagoStore.orderPizza("cheese");

        PizzaStore nyStore = new NYStylePizzaStore();
        nyStore.orderPizza("clam");
    }
}
