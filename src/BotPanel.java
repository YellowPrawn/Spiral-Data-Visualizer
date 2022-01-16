import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BotPanel extends JPanel {
    // needs the spiral image
    int panelSize = 700;
    Image image;

    public BotPanel() {
        setSize(panelSize, panelSize);
        BufferedImage img = null;
        try {
            image = ImageIO.read(getClass().getResource("/images/spiral.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
