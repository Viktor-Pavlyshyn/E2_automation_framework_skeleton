package com.epam.stepsdef;

import io.cucumber.java.en.Given;
import reflection.ReflectionApp;

/*
* TODO
 * 1. Rename package stepdef -> definitions. Name should be obvious
 * 2. Rename class name like ReflectionDefinitions. There is no any tests. Only steps and verifications.
 *    Our tests are feature files
 * 3. Use formatter at least default in IDEA
 * */

public class ReflectionTest {

    @Given("^print$")
    public void printResult() {
        new ReflectionApp().runApp();
    }
}
