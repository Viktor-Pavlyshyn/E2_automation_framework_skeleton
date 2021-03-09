package patterns.core.composite.developerimpl;

import patterns.core.composite.Developer;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes code...");
    }
}
