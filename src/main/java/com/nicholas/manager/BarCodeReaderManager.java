package com.nicholas.manager;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

public class BarCodeReaderManager {

    public static String readQRCode(String filePath) {
        Result result = null;
        try {
            InputStream barCodeInputStream = new FileInputStream(filePath);
            BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

            LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            result = reader.decode(bitmap);

        } catch (Exception ex) {

        }

        return result.getText();
    }
}
