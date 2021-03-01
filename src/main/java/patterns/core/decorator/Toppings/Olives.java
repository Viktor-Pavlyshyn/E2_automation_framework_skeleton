package patterns.core.decorator.Toppings;

import patterns.core.decorator.CrustPizza;
import patterns.core.decorator.PizzaComponent;

public class Olives extends PizzaComponent {

    public Olives(CrustPizza crustPizza) {
        this.crustPizza = crustPizza;
    }

    public String getDescription() {
        return crustPizza.getDescription() + ", Olives";
    }

    public double cost() {
        return crustPizza.cost() + 8.8;
    }
}
