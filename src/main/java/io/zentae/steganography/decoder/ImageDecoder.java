package io.zentae.steganography.decoder;

import com.google.common.primitives.Bytes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageDecoder implements Decoder<Image> {

    private final Image source;

    public ImageDecoder(Image source) {
        this.source = source;
    }

    @Override
    public String decode(Image encoded) {
        // Get source and encoded images.
        BufferedImage sourceImage = (BufferedImage) source;
        BufferedImage encodedImage = (BufferedImage) encoded;
        // Init byte list.
        List<Byte> bytes = new ArrayList<>();
        // Go through the image.
        for(int x = 0; x < encodedImage.getWidth(); x++) {
            for(int y = 0; y < encodedImage.getHeight(); y++) {
                int encodedRGB = encodedImage.getRGB(x, y);
                int sourceRGB = sourceImage.getRGB(x, y);
                int diff = encodedRGB - sourceRGB;
                // Check if the current pixel has some data encoded.
                if(diff != 0) {
                    System.out.println(diff);
                    bytes.add((byte) Math.abs(diff));
                }
            }
        }
        // Return encoded data.
        return new String(Bytes.toArray(bytes));
    }
}
