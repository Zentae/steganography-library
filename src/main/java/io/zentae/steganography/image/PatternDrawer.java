package io.zentae.steganography.image;

import io.zentae.steganography.patterns.EncryptionPattern;
import io.zentae.steganography.patterns.LinePattern;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PatternDrawer extends Drawer {

    private final EncryptionPattern pattern;

    public static void main(String[] args) {
        byte[] message = "aaa".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(message));

        try {
            BufferedImage sourceImage = ImageIO.read(new File(System.getProperty("user.dir") + "/test.jpg"));
            Drawer patternDrawer = new PatternDrawer(sourceImage, new LinePattern(new Dimension(10, 10), message));
            BufferedImage encodedImage = (BufferedImage)patternDrawer.draw();
            sourceImage = ImageIO.read(new File(System.getProperty("user.dir") + "/test.jpg"));
            //File encodedImageFile = new File(System.getProperty("user.dir") + "/final.jpg");
            //ImageIO.write(encodedImage, "JPEG", encodedImageFile);

            for(int x = 0; x < encodedImage.getWidth(); x++) {
                for(int y = 0; y < encodedImage.getHeight(); y++) {
                    int encodedRGB = encodedImage.getRGB(x, y);
                    int sourceRGB = sourceImage.getRGB(x, y);
                    int diff = encodedRGB - sourceRGB;

                    if(diff != 0)
                        System.out.println(diff);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PatternDrawer(Image image, EncryptionPattern pattern) {
        super(image);

        this.pattern = pattern;
    }

    public Image draw() {
        BufferedImage image = (BufferedImage)getImage();
        // Go through the image.
        for(int[] coordinates : pattern.get()) {
            int x = coordinates[0];
            int y = coordinates[1];

            System.out.println("x: " + x);
            System.out.println("y: " + y);
        }
        /*for(int i = 0; i < message.length; i++) {
            // [[1, 0], [2, 0], [3, 0]]
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            System.out.println("x:" + x + " y:" + y + " byte:" + message[i]);

            image.setRGB(x, y, image.getRGB(x, y) + message[i]);
        } */
        // Return the drawn image.
        return image;
    }
}
