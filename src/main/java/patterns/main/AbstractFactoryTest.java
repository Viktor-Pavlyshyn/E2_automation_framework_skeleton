package patterns.main;


import patterns.core.abstractfactory.Pay;
import patterns.core.abstractfactory.Pizza;
import patterns.core.abstractfactory.PizzaStore;
import patterns.core.abstractfactory.newabstractfactory.FurnitureFactory;
import patterns.core.abstractfactory.newabstractfactory.factoryimpl.ModernFactory;
import patterns.core.abstractfactory.newabstractfactory.factoryimpl.VictorianFactory;
import patterns.core.abstractfactory.storeimpl.ChicagoStylePizzaStore;
import patterns.core.abstractfactory.storeimpl.NYStylePizzaStore;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizzaCh = chicagoStore.orderPizza("cheese");
        System.out.println(pizzaCh.getClass().getSimpleName() + " done.");

        Pay payInCash = chicagoStore.payForThePizza("cash");
        System.out.println(payInCash.getClass().getSimpleName() + " done.");

        PizzaStore nyStore = new NYStylePizzaStore();

        Pizza pizzaCl = nyStore.orderPizza("clam");
        System.out.println(pizzaCl.getClass().getSimpleName() + " done.");

        Pay payInCard = nyStore.payForThePizza("cash");
        System.out.println(payInCard.getClass().getSimpleName() + " done.");


        ///// new factory
        FurnitureFactory modern = new ModernFactory();
        FurnitureFactory victorian = new VictorianFactory();

        modern.createChair();
        modern.createSofa();

        victorian.createChair();
        victorian.createSofa();
    }
}
