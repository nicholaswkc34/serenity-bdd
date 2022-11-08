package com.nicholas.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForAjax implements ExpectedCondition<Boolean> {

	@Override
	public Boolean apply(WebDriver driver) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		
		return jsDriver.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
	}

}
