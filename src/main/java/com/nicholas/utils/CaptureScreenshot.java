package com.nicholas.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot {

	public CaptureScreenshot() {
	}
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
	
	public static String captureScreen(WebDriver driver, String screenName) throws IOException{
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir") +"\\report\\" + screenName + ".png";
		
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		
		return dest;
	}
		
	public static String generateFileName(String feature){
		Date date = new Date();
		String fileName = feature + "_" + dateFormat.format(date);
		return fileName;
	}
}
