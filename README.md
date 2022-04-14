# steganography-library
Lightweight steganography library made with love in java <3.
## Usage
Encode a message
````java
// Getting the source image.
byte[] message = "Example message"
        .getBytes(StandardCharsets.UTF_8);
Encoder<Image> imageEncoder = new ImageEncoder(sourceImage);
Image encodedImage = imageEncoder.encode(message);
````
Decode a message
````java
// Getting the encoded image.
Decoder<Image> imageDecoder = new ImageDecoder(encodedImage);
String decodedMessage = imageDecoder.decode(sourceImage);
````
