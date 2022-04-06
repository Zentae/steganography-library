package io.zentae.steganography.patterns;

import java.awt.*;

public class LinePattern extends EncryptionPattern {

    public LinePattern(Dimension dimension, byte[] message) {
        super(dimension, message);
    }

    public int[][] get() {
        Dimension dimension = getDimension();
        int[][] pattern = new int[(int)dimension.getHeight()][(int)dimension.getWidth()];
        byte[] message = getMessage();

        int i = 0;
        for(int x = 0; x < dimension.getWidth(); x++) {
            for(int y = 0; y < dimension.getHeight(); y++) {
                if(i + 1 > message.length)
                    break;
                pattern[x][y] = getMessage()[i];
                i++;
            }
        }

        return pattern;
    }
}
