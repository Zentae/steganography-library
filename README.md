# steganography-encrypter
Lightweight message encryptor using images.
## Usage
````java
// Getting the image.
byte[] message = "Example message"
        .getBytes(StandardCharsets.UTF_8);
Drawer drawer = new EncryptorDrawer(image, message);
Image encryptedImage = drawer.draw();
````
