package com.epam.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reflection.annotation.Invoke;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static reflection.utils.ReflectionUtils.*;

public class ReflectionDefinitions {

    private Class clazz;
    private Object object;

    @Given("Class name - {string}")
    public void intClass(String className) {

        try {
            clazz = Class.forName(className);
            object = clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Then("Verify if current Object.getName equals {string}")
    public void verifyClassName(String className) {

        assertEquals(clazz.getName(), className);
    }

    @And("Set value - {int} in private field - {string}")
    public void setValueInPrivateField(int fieldValue, String fieldName) {

        try {
            Field field = clazz.getDeclaredField(fieldName);
            boolean flag = field.isAccessible();

            field.setAccessible(true);
            field.set(object, fieldValue);
            field.setAccessible(flag);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Then("Verify if method - {string} return value - {int}")
    public void verifyReturnValueOfMethod(String methodName, int fieldValue) {

        try {
            assertEquals(clazz.getDeclaredMethod(methodName).invoke(object), fieldValue);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Then("Verify if field - {string} return value - {int}")
    public void verifyFieldValue(String fieldName, int value){

        int declaredField = 0;

        try {
            Field field = clazz.getDeclaredField(fieldName);
            boolean flag = field.isAccessible();
            field.setAccessible(true);

            declaredField = field.getInt(object);
            field.setAccessible(flag);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }



        assertEquals(declaredField, value);

    }

    @Then("Verify method = {string} with annotation field name - {string} and value false  and expected sum = {int}")
    public void verifyAnnotationValue(String nameMethod, String fieldAnnName, int expectedSum) {

        saveAnnotation(object);

        Method[] listMethod = clazz.getDeclaredMethods();

        Stream.of(listMethod).forEach(method -> {
            if (method.isAnnotationPresent(Invoke.class)){
                assertTrue(method.getAnnotation(Invoke.class).state());
            }
        });

        setAnnotationValueByName(object, nameMethod, fieldAnnName, false, Invoke.class);
        int sum = getCalculatedValue(object);

        assertEquals(sum, expectedSum);

        returnDefaultAnnotation(object);
    }

}
