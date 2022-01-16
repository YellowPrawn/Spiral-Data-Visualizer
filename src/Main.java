import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// creates an instance of TheSpiraGui -- which is the JFRame that holds the other panels
public class Main {
    private static ArrayList<BufferedImage> frames;
    public static void main(String[] args) throws IOException {

        String[] provinces = {"Canada", "British Columbia", "Alberta", "Saskatchewan", "Manitoba", "Ontario", "Quebec", "Newfoundland and Labrador", "New Brunswick", "Nova Scotia", "Prince Edward Island", "Yukon", "Northwest Territories", "Nunavut"};
        // for testing purposes im gonna just test one frame
        TheSpiralGui spiralGui = new TheSpiralGui("Alberta");
        frames = (ArrayList<BufferedImage>) spiralGui.getFrames().clone();
        saveAsGif("Alberta");
       /* for(String province : provinces) {
            TheSpiralGui spiralGui = new TheSpiralGui(province);
            saveAsGif("Alberta");
        }*/
    }

    public static void saveAsGif(String province) throws IOException {
        BufferedImage first = frames.get(0);
        String currentDir = new File(".").getAbsolutePath();
        System.out.println ("Current directory: " + currentDir);
        ImageOutputStream output = new FileImageOutputStream(new File("./data/" + province + ".gif"));
        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
        writer.writeToSequence(first);

        for (BufferedImage frame : frames) {
            writer.writeToSequence(frame);
        }

        writer.close();
        output.close();
    }
}
