package patterns.core.decorator.pizzas;

import patterns.core.decorator.CrustPizza;

public class ThinCrustPizza extends CrustPizza {

    public ThinCrustPizza() {
        description = "ThinCrustPizza";
    }

    @Override
    public double cost() {
        return 90.50;
    }
}
