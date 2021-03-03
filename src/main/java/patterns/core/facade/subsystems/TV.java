package patterns.core.facade.subsystems;

public class TV {
    private State stateTV;

    public TV() {
        this.stateTV = State.OFF;
    }

    public void switchOnTV(){
        stateTV = State.ON;
        System.out.println("TV - switched on.");
    }

    public void switchOffTV(){
        stateTV = State.OFF;
        System.out.println("TV - switched off.");
    }
}
