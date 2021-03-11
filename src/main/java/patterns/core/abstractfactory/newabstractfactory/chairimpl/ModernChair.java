package patterns.core.abstractfactory.newabstractfactory.chairimpl;

import patterns.core.abstractfactory.newabstractfactory.Chair;

public class ModernChair implements Chair {
    @Override
    public void printChairName() {
        System.out.println("Modern Chair");
    }
}
