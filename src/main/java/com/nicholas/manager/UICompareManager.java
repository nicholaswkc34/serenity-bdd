package com.nicholas.manager;

import com.applitools.eyes.FileLogger;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.awt.*;


public class UICompareManager {


    private Eyes eyes;
    private CryptoManager crypt;
    private PropertiesManager pm;

    private Logger log = LogManager.getLogger(UICompareManager.class);

    public UICompareManager() {
        eyes = new Eyes();
        crypt = CryptoManager.getInstance(System.getProperty("user.dir") + "\\credential\\salt.txt");
        pm = PropertiesManager.createInstance();
    }

    // ============================================================================================
    public synchronized void setup(WebDriver driver, String windowNameStr) {
        try {
            eyes.setApiKey("VZx7EDIRSpA27Jih2hF6WfyDQJsijLle6tt5LexP1L4110"); //crypt.decryptPwd(".\\credential\\peter_wong_wims.txt")
            /*eyes.setProxy(new ProxySettings(pm.getProperties().getProperty("https_proxy"),
                    pm.getProperties().getProperty("proxy_username"),
                    pm.getProperties().getProperty("proxy_password")));*/
            eyes.setForceFullPageScreenshot(true);
            eyes.setMatchLevel(MatchLevel.LAYOUT);
            //eyes.setBatch(bi);
            eyes.setSendDom(false);
            eyes.setLogHandler(new FileLogger("..\\log\\applitools.log",true,true)); //new StdoutLogHandler(true)
            eyes.setAppName("AT");
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double width = screenSize.getWidth();
            double height = screenSize.getHeight();
            eyes.open(driver, "AT", windowNameStr, new RectangleSize((int)width, (int)height-160)); // 1920 920 1366 X 608
            /*
             * GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
             * int width = gd.getDisplayMode().getWidth();
             * int height = gd.getDisplayMode().getHeight();
             *
             */

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

    }
    // ============================================================================================
    public synchronized Eyes getEyes() {
        return eyes;
    }

}
