package io.zentae.steganography.encoder;

public interface Encoder<T> {

    T encode(byte[] message);
}
