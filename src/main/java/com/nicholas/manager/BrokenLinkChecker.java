package com.nicholas.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BrokenLinkChecker {

    private Logger log = LogManager.getLogger(BrokenLinkChecker.class);

    public BrokenLinkChecker() {
    }

    public Map<URL, Boolean> checkBrokenLink(WebDriver driver) {
        Map<URL, Boolean> resultMap = new HashMap<URL, Boolean>();

        try {
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            for(int i=0;i<allLinks.size();i++) {
                WebElement ele= allLinks.get(i);
                String urlLink=ele.getAttribute("href");
                URL aURL = new URL(urlLink);
                boolean result = checkSingleBrokenLink(urlLink);

                resultMap.put(aURL, result);
            }


        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return resultMap;
    }


    public Boolean checkSingleBrokenLink(String linkUrl) {
        Boolean isBroken = false;

        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();

            if (httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  {
                isBroken = false;
            }
            else {
                isBroken = true;
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return isBroken;
    }

}