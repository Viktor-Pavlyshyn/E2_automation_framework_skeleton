package com.epam.stepsdef;

import io.cucumber.java.en.Given;
import reflection.ReflectionApp;

public class ReflectionTest {

    @Given("^print$")
    public void printResult(){
        new ReflectionApp().runApp();
    }
}
