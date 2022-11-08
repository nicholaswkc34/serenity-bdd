package com.nicholas.manager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {


    Properties prop;
    InputStream input;

    private static PropertiesManager obj = null;
    private static Logger log = LogManager.getLogger(PropertiesManager.class);
    // =====================================================================================
    private PropertiesManager() {
        prop = new Properties();
        try {
            String configFile = System.getProperty("propertyFile");
            input = new FileInputStream("config.properties");
            loadFile();
        } catch (FileNotFoundException ex) {
            log.error(ex.getMessage());
        }
    }
    // =====================================================================================
    public static PropertiesManager createInstance() {
        try {
            if (obj == null) {
                obj = new PropertiesManager();
                obj.loadFile();
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return obj;
    }
    // =====================================================================================
    public void loadFile() {
        try {
            prop.load(input);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
    // =====================================================================================
    public Properties getProperties() {
        return prop;
    }
    // =====================================================================================

}
