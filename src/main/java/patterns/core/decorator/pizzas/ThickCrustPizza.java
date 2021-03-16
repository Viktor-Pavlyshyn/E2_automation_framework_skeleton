package patterns.core.decorator.pizzas;

import patterns.core.decorator.CrustPizza;

public class ThickCrustPizza extends CrustPizza {
    public ThickCrustPizza() {
        description = "ThickCrustPizza";
    }

    @Override
    public double cost() {
        return 70.30;
    }
}
