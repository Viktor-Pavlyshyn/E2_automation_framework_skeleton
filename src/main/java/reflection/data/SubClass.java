package reflection.data;

import reflection.annotation.MyAnnotation;

/*
*TODO
* Make method parameters final
* */

public class SubClass extends SupperClass {
    //Added space here
    private String subClassNameField;

    public SubClass(String subClassNameField) {
        this.subClassNameField = subClassNameField;
    }

    @MyAnnotation("annotation value")
    public String getSubClassNameField() {
        return subClassNameField;
    }

    public void printParam(String str, int number) {
        System.out.println("String value - " + str + ", int - value - " + number);
    }
}
