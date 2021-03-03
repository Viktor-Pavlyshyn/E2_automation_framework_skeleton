package patterns.core.facade;

import patterns.core.facade.subsystems.HomeSecuritySystem;
import patterns.core.facade.subsystems.Lights;
import patterns.core.facade.subsystems.TV;

public class HomeFacadeImpl implements HomeFacade{
    private HomeSecuritySystem homeSecuritySystem;
    private Lights lights;
    private TV tv;

    public HomeFacadeImpl() {
        this.homeSecuritySystem = new HomeSecuritySystem();
        this.lights = new Lights();
        this.tv = new TV();
    }

    @Override
    public void leaveHome() {
        lights.switchOffLight();
        tv.switchOffTV();
        homeSecuritySystem.enabledSecuritySystem();
    }

    @Override
    public void arriveHome() {
        lights.switchOnLight();
        tv.switchOnTV();
        homeSecuritySystem.disabledSecuritySystem();
    }
}
