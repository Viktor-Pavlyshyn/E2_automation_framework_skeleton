package patterns.core.factorymethod.storeimpl;

import patterns.core.factorymethod.Pizza;
import patterns.core.factorymethod.PizzaStore;
import patterns.core.factorymethod.pizzaimpl.NYStyleCheesePizza;
import patterns.core.factorymethod.pizzaimpl.NYStyleClamPizza;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        if(name.equals("cheese")){
            pizza = new NYStyleCheesePizza();
        } else if (name.equals("clam")){
            pizza = new NYStyleClamPizza();
        }

        return pizza;
    }
}
