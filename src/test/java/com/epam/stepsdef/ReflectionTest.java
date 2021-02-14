package com.epam.stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reflection.annotation.Invoke;
import reflection.data.SumClass;
import reflection.service.ReflectionService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReflectionTest {


    @Given("^Verify class name$")
    public void verifyClass(){
        SumClass sumClass = new SumClass();
        Class clazz = sumClass.getClass();

        assertEquals(clazz.getName(),"reflection.data.SumClass");

    }

    @Then("^Verify getter returns expected value of field which was set by reflection$")
    public void verifyGetter() throws NoSuchFieldException, IllegalAccessException {
        SumClass sumClass = new SumClass();
        int checkInt = 6;
        Class clazz = sumClass.getClass();

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

        assertEquals( declaredField, checkInt);

    }

    @Then("Verify method = {string} with annotation  false value annotation value and expected sum = {int}")
    public void verifyAnnotationValue(String nameMethod, int expectedSum) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SumClass sumClass = new SumClass();
        Class clazz = sumClass.getClass();
        Method[] listMethod = clazz.getDeclaredMethods();

        for (Method method : listMethod){
            if (method.isAnnotationPresent(Invoke.class)){
                assertTrue(method.getAnnotation(Invoke.class).flag());
            }
        }

        ReflectionService reflectionService = new ReflectionService();
        reflectionService.setAnnotationValueByName(sumClass, nameMethod);

        int sum = reflectionService.getCalculatedValue(sumClass);

        assertEquals(sum, expectedSum);
    }
}
