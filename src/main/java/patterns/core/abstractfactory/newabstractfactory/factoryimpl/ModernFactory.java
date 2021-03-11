package patterns.core.abstractfactory.newabstractfactory.factoryimpl;

import patterns.core.abstractfactory.newabstractfactory.Chair;
import patterns.core.abstractfactory.newabstractfactory.FurnitureFactory;
import patterns.core.abstractfactory.newabstractfactory.Sofa;
import patterns.core.abstractfactory.newabstractfactory.chairimpl.ModernChair;
import patterns.core.abstractfactory.newabstractfactory.sofaipml.ModernSofa;

public class ModernFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
