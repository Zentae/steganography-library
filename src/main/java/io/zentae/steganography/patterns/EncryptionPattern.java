package io.zentae.steganography.patterns;

import java.awt.*;

public abstract class EncryptionPattern {

    private final Dimension dimension;
    private final byte[] message;

    public EncryptionPattern(Dimension dimension, byte[] message) {
        this.dimension = dimension;
        this.message = message;
    }

    protected Dimension getDimension() {
        return dimension;
    }
    protected byte[] getMessage() { return message; }

    public abstract int[][] get();

}
