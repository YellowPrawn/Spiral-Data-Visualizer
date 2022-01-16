import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BotPanel extends JPanel {
    int panelSize = 700;
    Image image;

    // this class basically just displays the spiral image
    public BotPanel(String file) {
        setSize(panelSize, panelSize);
        BufferedImage img = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/" + file + ".png")));
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
