package patterns.core.template;

public class Job extends Template{
    @Override
    void stepOne() {
        System.out.println("step One");
    }

    @Override
    void stepTwo() {
        System.out.println("step Two");
    }

    @Override
    void stepThree() {
        System.out.println("step Three");
    }
}
