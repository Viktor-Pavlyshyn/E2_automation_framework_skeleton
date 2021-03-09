package patterns.core.decorator.Toppings;

import patterns.core.decorator.CrustPizza;
import patterns.core.decorator.PizzaComponent;

public class Cheese extends PizzaComponent {

    public Cheese(CrustPizza crustPizza) {
        this.crustPizza = crustPizza;
    }

    public String getDescription() {
        return crustPizza.getDescription() + ", Cheese";
    }

    public double cost() {
        return crustPizza.cost() + 12.4;
    }
}
