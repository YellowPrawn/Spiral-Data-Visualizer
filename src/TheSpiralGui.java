import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// The main window that holds all the panels
public class TheSpiralGui {
    private final String province;
    JFrame window;
    JLayeredPane jLayeredPane; // used to layer the diff parts of the graph (circle, spiral, axes)
    BotPanel bottomSpiralPanel; // panel of the spiral image
    MidPanel middleCirclePanel; // panel of the expanding circle
    TopPanel topAxesPanel; // panel of the axes
    ArrayList<BufferedImage> frames = new ArrayList<>();

    int windowSize = 700;

    public TheSpiralGui(String province) {
        // initializing everything
        this.province = province;
        window = new JFrame();
        jLayeredPane = new JLayeredPane();
        bottomSpiralPanel = new BotPanel(province);
        middleCirclePanel = new MidPanel(this);
        topAxesPanel = new TopPanel();

        // rest of the methods to set up the window
        setUpLayeredPanel();
        setUpFrame();
    }

    // sets up the JFrame and adds the panel container to it (visContainer)
    public void setUpFrame() {
        window.setSize(windowSize, windowSize);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(jLayeredPane);
    }

    // DONT change please, this orders the panels so they overlap correctly
    public void setUpLayeredPanel() {
        jLayeredPane.add(bottomSpiralPanel, 0, 0);
        jLayeredPane.add(middleCirclePanel, 1, 0);
        jLayeredPane.add(topAxesPanel, 2, 0);
    }

    public void recordFrame() {
        try {
            if(!MidPanel.stop) {
                BufferedImage image = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = image.createGraphics();
                window.paint(graphics2D);
                frames.add(image);
            }
        }
        catch(Exception exception) {}
    }

    public ArrayList<BufferedImage> getFrames() {
        return frames;
    }
}
