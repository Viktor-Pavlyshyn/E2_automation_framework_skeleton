package patterns.main;

import patterns.core.factorymethod.Pizza;
import patterns.core.factorymethod.PizzaStore;
import patterns.core.factorymethod.storeimpl.ChicagoStylePizzaStore;
import patterns.core.factorymethod.storeimpl.NYStylePizzaStore;

public class FactoryMethodTest {
    public static void main(String[] args) {
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        Pizza pizza = chicagoStore.orderPizza("cheese");
        System.out.println(pizza.getClass().getSimpleName() + " done.");

        PizzaStore nyStore = new NYStylePizzaStore();
        nyStore.orderPizza("clam");
        System.out.println(pizza.getClass().getSimpleName() + " done.");
    }
}
