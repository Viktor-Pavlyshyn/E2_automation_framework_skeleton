package patterns.core.factorymethod;

public abstract class PizzaStore {

    public abstract Pizza createPizza(String name);

    public void orderPizza(String namePizza){
        Pizza pizza = createPizza(namePizza);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
