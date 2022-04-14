package io.zentae.steganography.encoder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageEncoder implements Encoder<Image> {

    private final Image source;

    public ImageEncoder(Image source) {
        this.source = source;
    }

    @Override
    public Image encode(byte[] message) {
        BufferedImage image = (BufferedImage) source;
        // Go through the image.
        int i = 0;
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                int rgb = image.getRGB(x, y) + message[i];
                image.setRGB(x, y, rgb);

                if(i + 1 >= message.length)
                    break;

                i++;
            }

            if(i + 1 >= message.length)
                break;
        }

        // Return the drawn image.
        return image;
    }
}
