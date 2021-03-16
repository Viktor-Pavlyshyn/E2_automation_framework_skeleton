package patterns.core.factorymethod;

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
}
