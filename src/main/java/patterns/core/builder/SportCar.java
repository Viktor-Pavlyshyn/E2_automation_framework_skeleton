package patterns.core.builder;

import lombok.Getter;

@Getter
public class SportCar {
    private String name;
    private String color;
    private int maxSpeed;

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    public static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build(){
            return new SportCar(this);
        }
    }
}
