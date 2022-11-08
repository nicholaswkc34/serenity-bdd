package com.nicholas.manager;

import com.google.common.io.Files;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.util.Scanner;

public class CryptoManager {
    private static TextEncryptor encryptor;
    private static CryptoManager crypto;

    private static Logger log = LogManager.getLogger(CryptoManager.class);
    //=============================================================================================
    private CryptoManager() {
    }
    //=============================================================================================
    public static CryptoManager getInstance(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))){
            if (crypto == null) {
                String password = "demouser";
                Security.setProperty("crypto.policy", "unlimited");
                crypto = new CryptoManager();

                final String salt = sc.nextLine();
                crypto.encryptor = Encryptors.text(password, salt);

                // final String salt = KeyGenerators.string().generateKey();
                //Files.write(salt.getBytes(), new File(System.getProperty("user.dir") + "\\credential\\salt.txt"));
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return crypto;
    }
    //=============================================================================================
    public synchronized void generateEncryptedPwd(final String encryptPwd, String filePath) {
        try {
            File encryptedFile = new File(filePath);
            Files.write(encryptor.encrypt(encryptPwd).getBytes(), encryptedFile);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
    //=============================================================================================
    public synchronized String decryptPwd(String filePath) {
        String decryptedStr = "";
        try (Scanner sc = new Scanner(new File(filePath))) {
            decryptedStr = sc.nextLine();
            decryptedStr = encryptor.decrypt(decryptedStr);

        } catch (IOException ex) {
            log.error(ex.getMessage());
        }

        return decryptedStr;
    }
}
