package patterns.main;

import patterns.core.facade.HomeFacade;
import patterns.core.facade.HomeFacadeImpl;

public class FacadeTest {
    public static void main(String[] args) {
        HomeFacade homeFacade = new HomeFacadeImpl();

        homeFacade.arriveHome();

        homeFacade.leaveHome();
    }
}
