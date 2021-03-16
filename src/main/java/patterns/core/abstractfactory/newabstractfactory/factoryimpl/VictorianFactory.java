package patterns.core.abstractfactory.newabstractfactory.factoryimpl;

import patterns.core.abstractfactory.newabstractfactory.Chair;
import patterns.core.abstractfactory.newabstractfactory.FurnitureFactory;
import patterns.core.abstractfactory.newabstractfactory.Sofa;
import patterns.core.abstractfactory.newabstractfactory.chairimpl.VictorianChair;
import patterns.core.abstractfactory.newabstractfactory.sofaipml.VictorianSofa;

public class VictorianFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
