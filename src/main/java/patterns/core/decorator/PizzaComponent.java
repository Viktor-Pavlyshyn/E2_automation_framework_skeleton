package patterns.core.decorator;

public abstract class PizzaComponent extends CrustPizza{
    public CrustPizza crustPizza;

    public abstract String getDescription();
}
