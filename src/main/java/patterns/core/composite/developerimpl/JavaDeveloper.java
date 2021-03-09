package patterns.core.composite.developerimpl;

import patterns.core.composite.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes code...");
    }
}
