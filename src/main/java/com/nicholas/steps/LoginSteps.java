package com.nicholas.steps;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends PageObject {

    @Step("Enter Username")
    public void inputUserName(String userName) {
        $(By.name("username")).sendKeys((userName));
    }

    @Step("Enter Password")
    public void inputPassword(String passWord) {
        $(By.name("password")).sendKeys((passWord));
    }

    @Step("Click Submit Button")
    public void clickLogin() {
        $(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

    @Step("Error Message on unsuccessful login")
    public String errorMessage() {
        String actualErrorMessage = $(By.id("spanMessage")).getText();
        return actualErrorMessage;
    }

    @Step("Click Forget Password Link")
    public void clickForgetPasswordLink() {
        $(By.linkText("Forgot your password?")).click();

    }



}
