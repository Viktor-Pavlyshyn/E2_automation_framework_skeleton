package patterns.core.facade.subsystems;

public class Lights {
    private State stateLight;

    public Lights() {
        this.stateLight = State.OFF;
    }

    public void switchOnLight(){
        stateLight = State.ON;
        System.out.println("Light - switched on.");
    }

    public void switchOffLight(){
        stateLight = State.OFF;
        System.out.println("Light - switched off.");
    }
}
