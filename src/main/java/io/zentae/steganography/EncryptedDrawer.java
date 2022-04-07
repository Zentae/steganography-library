package io.zentae.steganography;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EncryptedDrawer extends Drawer {

    private final byte[] message;

    public EncryptedDrawer(Image image, byte[] message) {
        super(image);
        this.message = message;
    }

    public Image draw() {
        BufferedImage image = (BufferedImage)getImage();
        // Go through the image.
        int i = 0;
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                int rgb = image.getRGB(x, y) + message[i];
                image.setRGB(x, y, rgb);
            }

            if(i + 1 > message.length)
                break;

            i++;
        }

        // Return the drawn image.
        return image;
    }
}
