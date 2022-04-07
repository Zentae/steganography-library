package io.zentae.steganography;

import java.awt.*;

public abstract class Drawer {

    private final Image image;

    public Drawer(Image image) {
        this.image = image;
    }

    /**
     * @return the {@link Image}
     */
    protected Image getImage() {
        return image;
    }

    /**
     * Draws and return the {@link Image}
     * @return the drawn {@link Image}
     */
    public abstract Image draw();
}
