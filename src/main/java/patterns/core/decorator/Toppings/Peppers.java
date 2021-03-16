package patterns.core.decorator.Toppings;

import patterns.core.decorator.CrustPizza;
import patterns.core.decorator.PizzaComponent;

public class Peppers extends PizzaComponent {

    public Peppers(CrustPizza crustPizza) {
        this.crustPizza = crustPizza;
    }

    public String getDescription() {
        return crustPizza.getDescription() + ", Peppers";
    }

    public double cost() {
        return crustPizza.cost() + 12.4;
    }
}
