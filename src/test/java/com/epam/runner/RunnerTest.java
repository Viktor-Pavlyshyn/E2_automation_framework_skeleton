package com.epam.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "message:target/cucumber-report",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = {"src/test/resources/features"},
        glue = {"com/epam/definitions"}, tags = "@selenide")
public class RunnerTest {
}
