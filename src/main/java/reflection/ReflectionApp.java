package reflection;

import reflection.annotation.MyAnnotation;
import reflection.data.SubClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApp {
    public void runApp() {
        SubClass subClass = new SubClass("subClass value");

        printClass(subClass);
        printField(subClass);
        printMethod(subClass);
        printAnnotation(subClass);
    }

    public void printClass(Object object) {

        System.out.println("=============Class================");

        Class clazz = object.getClass();
        System.out.println("Name - " + clazz.getName() + "\n" +
                "SimpleName - " + clazz.getSimpleName() + "\n" +
                "Superclass name - " + clazz.getSuperclass().getName());

        System.out.println("");
    }

    public void printField(Object object) {
        System.out.println("=============Field================");

        Class clazz = object.getClass();
        try {
            System.out.println("Declared Field - " + clazz.getDeclaredField("subClassNameField") + "\n" +
                    "Extended field - " + clazz.getField("supperClassNameField"));

            Field nameFieldSubClass = clazz.getDeclaredField("subClassNameField");

            boolean flag = nameFieldSubClass.isAccessible();

            nameFieldSubClass.setAccessible(true);
            nameFieldSubClass.set(object, "new value for subClassNameField");
            nameFieldSubClass.setAccessible(flag);


            System.out.println("Set new value to private field - " + clazz.getMethod("getSubClassNameField").invoke(object));

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

    public void printMethod(Object object) {
        System.out.println("=============Method================");

        Class clazz = object.getClass();

        try {
            System.out.println("Constructor name - " + clazz.getConstructor(String.class).getName());

            Method [] methodWithAnn = clazz.getMethods();

            System.out.println("All methods: ");
            for (Method method : methodWithAnn){
                System.out.println(method);
            }

            System.out.println("Run method with parameters");
            Method methodParam = clazz.getDeclaredMethod("printParam", String.class, int.class);
            methodParam.invoke(object , "Param value", 12);


        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }

    public void printAnnotation(Object object) {
        System.out.println("=============Annotation================");

        Class clazz = object.getClass();

        try {

            Method annMethod = clazz.getMethod("getSubClassNameField");

            MyAnnotation myAnnotation = annMethod.getAnnotation(MyAnnotation.class);

            System.out.println("Annotation value - " + myAnnotation.value());

            Method [] methodWithAnn = clazz.getDeclaredMethods();

            for (Method method : methodWithAnn){
                if(method.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println("Method name with annotation 'MyAnnotation' - " + method);
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("");
    }
}
