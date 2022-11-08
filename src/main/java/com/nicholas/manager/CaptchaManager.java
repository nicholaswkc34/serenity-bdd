package com.nicholas.manager;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;

public class CaptchaManager {

    private Logger log = LogManager.getLogger(CaptchaManager.class);

    public String validate(String filePath) {
        String result = null;
        File imageFile = null;

        try  {
            imageFile = new File(filePath);
            ITesseract instance = new Tesseract();  // JNA Interface Mapping
            instance.setDatapath(".\\tessdata"); // path to tessdata directory
            result = instance.doOCR(imageFile);
            System.out.println(result);

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return result;

    }

}

/*
 * http://www.deathbycaptcha.com/user/need-confirmation
 *
 *
 */
