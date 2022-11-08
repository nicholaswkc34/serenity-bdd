package com.nicholas.manager;

import org.jboss.aerogear.security.otp.Totp;


public class MFAManager {
    String otpSecretKeyStr;
    String twoFactorCode;

    public void enterAuthy() {

        try {
            otpSecretKeyStr = "NQYVIS2VNU7GKTKU"; // <- this 2FA secret key.

            Totp totp = new Totp(otpSecretKeyStr);
            //twoFactorCode = totp.now();
            //logger.info(twoFactorCode);
            Thread.sleep(2);
            //logger.info("Entering Authy");
            //enter2FA.sendKeys(twoFactorCode);


            //logger.info("Clicking on the submit button");
            //clickBtn.click();

            Thread.sleep(2);

        } catch (Exception e) {
            e.getMessage();
        }
    }


}
