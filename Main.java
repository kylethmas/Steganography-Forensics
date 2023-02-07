// Team E - Forensics Assessment
import javax.imageio.ImageIO;
import java.nio.charset.StandardCharsets;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
class steganography {
    public static void main(String[] args) throws IOException {
        encode("My message is secret!");
    }

    public static void encode(String secretMessage) throws IOException{
        // Read in image
        String imagePath = "C:\\Users\\Kyle\\University\\Forensics\\puppy1.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));

        // get dimensions
        int width = myPicture.getWidth();
        int height = myPicture.getHeight();

        byte[] messageBytes = secretMessage.getBytes(StandardCharsets.UTF_8);

        //write the data to the image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int colour = myPicture.getRGB(x,y);

                //Change the LSB of component
                // COME BACK TOO
                
                myPicture.setRGB(x,y, colour);
            }
        }

        //save image
        ByteArrayOutputStream pictureStream = new ByteArrayOutputStream();
        ImageIO.write(myPicture, "bmp", pictureStream);
        File outputPicture = new File("encrypted_picture.bmp");
        ImageIO.write(myPicture, "bmp", outputPicture);

    }
}