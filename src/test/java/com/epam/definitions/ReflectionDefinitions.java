package com.epam.definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reflection.annotation.Invoke;
import reflection.data.SumClass;
import reflection.service.ReflectionService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static reflection.service.ReflectionService.setValueForPrivateField;

/*
 * TODO
 * 3. Use formatter at least default in IDEA
 * */

public class ReflectionDefinitions {
    private static Map<String, Boolean> methodMap = new LinkedHashMap<>();

    @Before
    public void sutUp() {
        Class clazz = SumClass.class;
        Method[] methodWithAnn = clazz.getDeclaredMethods();
        for (Method method : methodWithAnn) {
            if (method.isAnnotationPresent(Invoke.class)) {
                boolean value = method.getAnnotation(Invoke.class).flag();
                methodMap.put(method.getName(), value);
            }
        }
    }

    @After
    public void cleanUp() throws NoSuchFieldException, IllegalAccessException {
        Class clazz = SumClass.class;
        Method[] methodWithAnn = clazz.getDeclaredMethods();
        for (Method method : methodWithAnn) {
            if (method.isAnnotationPresent(Invoke.class)) {
                boolean value = method.getAnnotation(Invoke.class).flag();
                boolean storedValue = methodMap.get(method.getName());
                if (storedValue != value) {
                    setValueForPrivateField(method.getAnnotation(Invoke.class), "flag", true);
                }
            }
        }

    }

    @Given("^Verify class name$")
    public void verifyClass() {
        Class clazz = SumClass.class;

        assertEquals(clazz.getName(), "reflection.data.SumClass");
    }

    @Then("^Verify getter returns expected value of field which was set by reflection$")
    public void verifyGetter() throws NoSuchFieldException, IllegalAccessException {
        SumClass sumClass = new SumClass();
        int checkInt = 6;
        Class clazz = SumClass.class;

        Field field = clazz.getDeclaredField("sum");
        boolean flag = field.isAccessible();

        field.setAccessible(true);
        field.set(sumClass, checkInt);
        field.setAccessible(flag);

        assertEquals(sumClass.getSum(), checkInt);
    }

    @And("^Verify method returns expected value invoked by reflection$")
    public void verifyValue() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int checkInt = 6;
        SumClass sumClass = new SumClass();
        Class clazz = sumClass.getClass();

        Field field = clazz.getDeclaredField("sum");
        boolean flag = field.isAccessible();

        field.setAccessible(true);
        field.set(sumClass, checkInt);
        field.setAccessible(flag);

        int reflectionSum = (int) clazz.getMethod("getSum").invoke(sumClass);

        assertEquals(reflectionSum, checkInt);
    }

    @Then("^Verify fields values after init object by reflection$")
    public void verifyFieldValue() throws NoSuchFieldException, IllegalAccessException {
        int checkInt = 0;
        SumClass sumClass = new SumClass();
        Class clazz = sumClass.getClass();

        Field field = clazz.getDeclaredField("sum");

        boolean flag = field.isAccessible();
        field.setAccessible(true);

        int declaredField = field.getInt(sumClass);
        field.setAccessible(flag);

        assertEquals(declaredField, checkInt);

    }

    @Then("Verify method = {string} with annotation  false value annotation value and expected sum = {int}")
    public void verifyAnnotationValue(String nameMethod, int expectedSum) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SumClass sumClass = new SumClass();
        Class clazz = sumClass.getClass();
        Method[] listMethod = clazz.getDeclaredMethods();

        for (Method method : listMethod) {
            if (method.isAnnotationPresent(Invoke.class)) {
                assertTrue(method.getAnnotation(Invoke.class).flag());
            }
        }

        ReflectionService reflectionService = new ReflectionService();
        reflectionService.setAnnotationValueByName(sumClass, nameMethod);

        int sum = reflectionService.getCalculatedValue(sumClass);

        assertEquals(sum, expectedSum);
    }
}
