package patterns.core.abstractfactory.newabstractfactory.chairimpl;

import patterns.core.abstractfactory.newabstractfactory.Chair;

public class VictorianChair implements Chair {
    @Override
    public void printChairName() {
        System.out.println("Victorian Chair");
    }
}
