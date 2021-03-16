package patterns.core.abstractfactory.pizzaimpl;

import patterns.core.abstractfactory.Pizza;

public class NYStyleCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing " + this.getClass().getSimpleName());
    }

    @Override
    public void bake() {
        System.out.println("baking " + this.getClass().getSimpleName());
    }

    @Override
    public void cut() {
        System.out.println("Cutting " + this.getClass().getSimpleName());
    }

    @Override
    public void box() {
        System.out.println("Boxing " + this.getClass().getSimpleName());
    }
}