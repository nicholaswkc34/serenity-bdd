package com.nicholaswkc.runner;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        publish = true,
        features = "src/main/resources/features",
        glue = "com.nicholas.stepDefinitions"
)
public class CucumberTestSuite {

}
