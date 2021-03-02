package patterns.core.iterator;

import java.util.Iterator;

public class Cafe {
    Menu dinerMenu;
    Menu pancakeHouseMenu;

    public Cafe(Menu dinerMenu, Menu pancakeHouseMenu) {
        this.dinerMenu = dinerMenu;
        this.pancakeHouseMenu = pancakeHouseMenu;
    }
    public void printDinerMenu(){

        printMenu(dinerMenu.createIterator());
    }

    public void printPancakeHouseMenu(){
        printMenu(pancakeHouseMenu.createIterator());
    }

    private void printMenu(Iterator<String> iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
