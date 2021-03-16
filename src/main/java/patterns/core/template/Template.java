package patterns.core.template;

public abstract class Template {
    abstract void stepOne();
    abstract void stepTwo();
    abstract void stepThree();

    public void templateMethod(){
        stepOne();
        stepTwo();
        stepThree();
    }
}
