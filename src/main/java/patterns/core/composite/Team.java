package patterns.core.composite;

import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Developer> developerList = new ArrayList<>();


    public void addDeveloper(Developer developer) {
        developerList.add(developer);
    }

    public void removeDeveloper(Developer developer) {
        developerList.remove(developer);
    }

    public void createProject() {
        System.out.println("Team creates project ... \n");
        developerList.forEach(Developer::writeCode);
    }
}
