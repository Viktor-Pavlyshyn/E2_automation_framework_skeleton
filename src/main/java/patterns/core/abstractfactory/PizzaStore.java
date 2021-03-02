package patterns.core.abstractfactory;

public abstract class PizzaStore {

    protected abstract Pizza createPizza(String name);

    public Pizza orderPizza(String namePizza){
        Pizza pizza = createPizza(namePizza);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pay choiceOfPayment(String name);

    public Pay payForThePizza(String namePayment){
        Pay pay = choiceOfPayment(namePayment);
        pay.pyaForTheOrder();
        return pay;
    }
}
