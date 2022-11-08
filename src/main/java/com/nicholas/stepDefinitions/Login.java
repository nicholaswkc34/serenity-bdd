package com.nicholas.stepDefinitions;

import com.nicholas.steps.DashboardSteps;
import com.nicholas.steps.ForgotPasswordSteps;
import com.nicholas.steps.LoginSteps;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.log4j.Logger;

public class Login {

    @Steps
    LoginSteps loginSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    ForgotPasswordSteps forgotPasswordSteps;


    private final Logger log = Logger.getLogger(Login.class);

    @Given("user is on home page")
    public void openPage() {
        loginSteps.open();
        log.info("User is on home page");

    }

    @When("user enter username")
    public void enterUsername() {
        loginSteps.inputUserName("Admin");
    }

    @When("user enter password")
    public void enterPassword( ) {
        loginSteps.inputPassword("admin123");
        loginSteps.clickLogin();
    }

    @Then("user logged in successfully and redirect to home page")
    public void clickOnLoginButton() {
        //dashboardSteps.loginVerify();
    }




}
