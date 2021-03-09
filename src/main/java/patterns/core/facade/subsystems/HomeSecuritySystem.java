package patterns.core.facade.subsystems;

public class HomeSecuritySystem {
    private State stateSecuritySystem;

    public HomeSecuritySystem() {
        this.stateSecuritySystem = State.OFF;
    }

    public void enabledSecuritySystem(){
        stateSecuritySystem = State.ON;
        System.out.println("Security System - enabled.");
    }

    public void disabledSecuritySystem(){
        stateSecuritySystem = State.OFF;
        System.out.println("Security System - disabled.");
    }
}
