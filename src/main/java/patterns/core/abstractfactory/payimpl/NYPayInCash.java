package patterns.core.abstractfactory.payimpl;

import patterns.core.abstractfactory.Pay;

public class NYPayInCash implements Pay {
    @Override
    public void pyaForTheOrder() {
        System.out.println(this.getClass().getSimpleName() + " in cash.");
    }
}