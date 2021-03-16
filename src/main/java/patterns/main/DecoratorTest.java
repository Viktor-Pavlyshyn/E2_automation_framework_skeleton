package patterns.main;

import patterns.core.decorator.CrustPizza;
import patterns.core.decorator.Toppings.Cheese;
import patterns.core.decorator.Toppings.Olives;
import patterns.core.decorator.pizzas.ThickCrustPizza;

public class DecoratorTest {
    public static void main(String[] args) {
        CrustPizza crustPizza = new ThickCrustPizza();
        crustPizza = new Cheese(crustPizza);
        crustPizza = new Cheese(crustPizza);
        crustPizza = new Olives(crustPizza);

        System.out.println(crustPizza.getDescription() + " $" + crustPizza.cost());
    }
}
