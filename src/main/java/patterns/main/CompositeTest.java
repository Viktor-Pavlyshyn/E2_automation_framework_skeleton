package patterns.main;

import patterns.core.composite.developerimpl.CppDeveloper;
import patterns.core.composite.Developer;
import patterns.core.composite.developerimpl.JavaDeveloper;
import patterns.core.composite.Team;

public class CompositeTest {
    public static void main(String[] args) {
        Team team = new Team();

        Developer firstJavaDeveloper = new JavaDeveloper();
        Developer secondJavaDeveloper = new JavaDeveloper();
        Developer cppDeveloper = new CppDeveloper();

        team.addDeveloper(firstJavaDeveloper);
        team.addDeveloper(secondJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();
    }
}
