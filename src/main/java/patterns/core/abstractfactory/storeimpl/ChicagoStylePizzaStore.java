package patterns.core.abstractfactory.storeimpl;

import patterns.core.abstractfactory.Pay;
import patterns.core.abstractfactory.Pizza;
import patterns.core.abstractfactory.PizzaStore;
import patterns.core.abstractfactory.payimpl.ChicagoPayByCard;
import patterns.core.abstractfactory.payimpl.ChicagoPayInCash;
import patterns.core.abstractfactory.pizzaimpl.ChicagoStyleCheesePizza;
import patterns.core.abstractfactory.pizzaimpl.ChicagoStyleClamPizza;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        if (name.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (name.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        }

        return pizza;
    }

    @Override
    protected Pay choiceOfPayment(String name) {
        Pay pay = null;
        if (name.equals("cash")) {
            pay = new ChicagoPayInCash();
        } else if (name.equals("card")) {
            pay = new ChicagoPayByCard();
        }

        return pay;
    }
}