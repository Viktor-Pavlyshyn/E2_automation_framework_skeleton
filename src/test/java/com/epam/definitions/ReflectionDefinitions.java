package com.epam.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reflection.annotation.Invoke;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static reflection.service.ReflectionService.*;

public class ReflectionDefinitions {

    private Class clazz;
    private Object object;

    @Given("Class name - {string}")
    public void intClass(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        clazz = Class.forName(className);
        object = clazz.getConstructor().newInstance();
    }

    @Then("Verify if current Object.getName equals {string}")
    public void verifyClassName(String className) {

        assertEquals(clazz.getName(), className);
    }

    @And("Set value - {int} in private field - {string}")
    public void setValueInPrivateField(int fieldValue, String fieldName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Field field = clazz.getDeclaredField(fieldName);
        boolean flag = field.isAccessible();

        field.setAccessible(true);
        field.set(object, fieldValue);
        field.setAccessible(flag);
    }

    @Then("Verify if method - {string} return value - {int}")
    public void verifyReturnValueOfMethod(String methodName, int fieldValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        assertEquals(clazz.getDeclaredMethod(methodName).invoke(object), fieldValue);
    }

    @Then("Verify if field - {string} return value - {int}")
    public void verifyFieldValue(String fieldName, int value) throws NoSuchFieldException, IllegalAccessException {

        Field field = clazz.getDeclaredField(fieldName);

        boolean flag = field.isAccessible();
        field.setAccessible(true);

        int declaredField = field.getInt(object);
        field.setAccessible(flag);

        assertEquals(declaredField, value);

    }

    @Then("Verify method = {string} with annotation false value annotation value and expected sum = {int}")
    public void verifyAnnotationValue(String nameMethod, int expectedSum) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {

        saveAnnotation(object);

        Method[] listMethod = clazz.getDeclaredMethods();

        Stream.of(listMethod).forEach(method -> {
            if (method.isAnnotationPresent(Invoke.class)) {
                assertTrue(method.getAnnotation(Invoke.class).flag());
            }
        });

        setAnnotationValueByName(object, nameMethod);
        int sum = getCalculatedValue(object);

        assertEquals(sum, expectedSum);

        returnDefaultAnnotation(object);
    }

}
