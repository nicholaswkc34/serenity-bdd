package com.nicholas.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToView {
	public void scrollToView(WebDriver driver, WebElement element) {
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		
		jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
