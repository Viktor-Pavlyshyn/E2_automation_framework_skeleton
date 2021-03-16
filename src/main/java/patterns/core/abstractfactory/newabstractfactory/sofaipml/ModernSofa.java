package patterns.core.abstractfactory.newabstractfactory.sofaipml;

import patterns.core.abstractfactory.newabstractfactory.Sofa;

public class ModernSofa implements Sofa {
    @Override
    public void printSofaName() {
        System.out.println("Modern Sofa");
    }
}
