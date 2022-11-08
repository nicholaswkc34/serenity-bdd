package com.nicholas.stepDefinitions;

import com.nicholas.manager.*;
import com.nicholas.utils.MyMailer;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;


public class GlobalHooks {

    public static DAOManager daoManager;
    public static MFAManager mfaManager;
    public static UICompareManager uiCompareManager;
    public static CryptoManager cryptoManager;
    public static SpringInitManager springInitManager;
    public static CaptchaManager captchaManager;
    public static PropertiesManager propertiesManager;
    public static BrokenLinkChecker brokenLinkChecker;

    private static MyMailer emailer;


    @BeforeAll
    public static void setup() {
        daoManager = new DAOManager();
        mfaManager = new MFAManager();
        uiCompareManager = new UICompareManager();
        cryptoManager = CryptoManager.getInstance(System.getProperty("user.dir") + "\\credential\\salt.txt");
        springInitManager = new SpringInitManager();
        captchaManager = new CaptchaManager();
        propertiesManager = PropertiesManager.createInstance();
        brokenLinkChecker = new BrokenLinkChecker();

        emailer = new MyMailer();

        System.out.println("Execute Global Before Hooks");

    }


    @AfterAll
    public static void tearDown() {
        System.out.println("Execute Global After Hooks");
        // Send report via email
        emailer.sendEmail();
    }


}
