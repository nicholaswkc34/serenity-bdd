package com.nicholas.steps;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class DashboardSteps extends PageObject {

    @Step("Successful login")
    public void loginVerify() {
        String dashboardTitle = $(By.id("welcome")).getText();
    }



}
