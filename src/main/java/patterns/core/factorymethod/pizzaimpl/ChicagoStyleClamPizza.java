package patterns.core.factorymethod.pizzaimpl;

import patterns.core.factorymethod.Pizza;

public class ChicagoStyleClamPizza implements Pizza {
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