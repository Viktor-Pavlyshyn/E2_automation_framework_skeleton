package reflection.data;

import reflection.annotation.MyAnnotation;

public class SubClass extends SupperClass {
//    TODO:
//    Discuss about final
    private String subClassNameField;

    public SubClass(String subClassNameField) {
        this.subClassNameField = subClassNameField;
    }

    @MyAnnotation("annotation value")
    public String getSubClassNameField() {
        return subClassNameField;
    }

    public void printParam(final String str, final int number) {
        System.out.println("String value - " + str + ", int - value - " + number);
    }
}
