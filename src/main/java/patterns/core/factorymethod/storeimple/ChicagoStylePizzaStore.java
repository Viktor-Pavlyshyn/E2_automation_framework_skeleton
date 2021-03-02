package patterns.core.factorymethod.storeimple;

import patterns.core.factorymethod.Pizza;
import patterns.core.factorymethod.PizzaStore;
import patterns.core.factorymethod.pizzaimpl.ChicagoStyleCheesePizza;
import patterns.core.factorymethod.pizzaimpl.ChicagoStyleClamPizza;

public class ChicagoStylePizzaStore  extends PizzaStore {
    @Override
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        if(name.equals("cheese")){
            pizza = new ChicagoStyleCheesePizza();
        } else if (name.equals("clam")){
            pizza = new ChicagoStyleClamPizza();
        }

        return pizza;
    }
}