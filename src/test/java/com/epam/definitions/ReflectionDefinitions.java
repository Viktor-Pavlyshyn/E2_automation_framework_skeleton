package com.epam.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reflection.annotation.Invoke;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static reflection.utils.ReflectionUtils.*;

public class ReflectionDefinitions {

    private Class clazz;
    private Object object;

    @Given("Class name - {string}")
    public void intClass(final String className) {

        clazz = getClazz(className);
        object = getNewInstance(clazz);
    }

    @Then("Verify if current Object.getName equals {string}")
    public void verifyClassName(final String className) {

        assertEquals(clazz.getName(), className);
    }

    @And("Set value - {int} in private field - {string}")
    public void setValueInPrivateField(final int fieldValue, final String fieldName) {

        setIntPrivateField(object, fieldName, fieldValue);
    }

    @Then("Verify if method - {string} return value - {int}")
    public void verifyReturnValueOfMethod(final String methodName, final int fieldValue) {

        assertEquals(invokeMethod(object, getDeclaredMethod(object, methodName)), fieldValue);
    }

    @Then("Verify if field - {string} return value - {int}")
    public void verifyFieldValue(final String fieldName, final int value) {

        assertEquals(getValueFromPrivateField(object, fieldName), value);
    }

    @Then("Verify method = {string} with annotation field name - {string} and value false and expected sum = {int}")
    public void verifyAnnotationValue(final String nameMethod, final String fieldAnnName, final int expectedSum) {

        saveAnnotation(object, Invoke.class);

        Stream.of(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Invoke.class))
                .forEach(method -> assertTrue(method.getAnnotation(Invoke.class).state()));

        setAnnotationValueByName(object, nameMethod, fieldAnnName, false, Invoke.class);

        assertEquals(getCalculatedValue(object, "sum", Invoke.class), expectedSum);

        returnDefaultAnnotation(object, fieldAnnName, Invoke.class, true);
    }
}
