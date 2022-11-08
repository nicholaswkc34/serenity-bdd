package com.nicholas.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForPageLoad implements ExpectedCondition<Boolean> {

	@Override
	public Boolean apply(WebDriver driver) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		
		return jsDriver.executeScript("return document.readyState").equals("Complete");
	}

}
