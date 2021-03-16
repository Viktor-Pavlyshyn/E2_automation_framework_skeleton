package patterns.core.decorator;

public abstract class CrustPizza {
    public String description = "CrustPizza";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
