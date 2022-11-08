package com.nicholas.steps;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class ForgotPasswordSteps extends PageObject {

    @Step("Verify Forget Password Page ")
    public boolean ForgetPasswordPage() {
        Boolean resetPasswordButton = $(By.id("btnSearchValues")).isDisplayed();

        return resetPasswordButton;
    }


}
