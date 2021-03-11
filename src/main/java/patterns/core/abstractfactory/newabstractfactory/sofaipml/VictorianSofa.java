package patterns.core.abstractfactory.newabstractfactory.sofaipml;

import patterns.core.abstractfactory.newabstractfactory.Sofa;

public class VictorianSofa implements Sofa {
    @Override
    public void printSofaName() {
        System.out.println("Victorian Sofa");
    }
}
