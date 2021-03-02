package patterns.core.abstractfactory.storeimpl;

import patterns.core.abstractfactory.Pay;
import patterns.core.abstractfactory.Pizza;
import patterns.core.abstractfactory.PizzaStore;
import patterns.core.abstractfactory.payimpl.ChicagoPayByCard;
import patterns.core.abstractfactory.payimpl.ChicagoPayInCash;
import patterns.core.abstractfactory.payimpl.NYPayByCard;
import patterns.core.abstractfactory.payimpl.NYPayInCash;
import patterns.core.abstractfactory.pizzaimpl.NYStyleCheesePizza;
import patterns.core.abstractfactory.pizzaimpl.NYStyleClamPizza;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        if (name.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (name.equals("clam")) {
            pizza = new NYStyleClamPizza();
        }

        return pizza;
    }

    @Override
    protected Pay choiceOfPayment(String name) {
        Pay pay = null;
        if (name.equals("cash")) {
            pay = new NYPayInCash();
        } else if (name.equals("card")) {
            pay = new NYPayByCard();
        }

        return pay;
    }
}
