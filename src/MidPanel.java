import javax.swing.*;
import java.awt.*;

public class MidPanel extends JPanel {

    public static boolean stop;
    int panelSize = 700;
    int radius = 0;
    int center = panelSize/2;
    TheSpiralGui gui;

    public MidPanel(TheSpiralGui gui) {
        stop = false;
        setUpPanel();
        setUpTimer();
        this.gui = gui;
    }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCircle(g);
            for (int x = 0; x <= panelSize; x++) {
                for (int y=0; y<= panelSize; y++) {
                    if (x != radius && y != radius) {
                        g.drawRect(x, y, 1, 1);
                    }
//                    if (x < (center - radius/2) || x > (center + radius/2) || y < (center - radius/2) || y > (center + radius/2)) {
//                        g.setColor(new Color(0,0,0));
//                    } else {
//                        g.setColor(new Color(0,0,0, 0));
//                    }
                    if (Math.sqrt(((x - panelSize/2)*(x - panelSize/2))+((y - panelSize/2)*(y - panelSize/2))) < radius/2) {
                        g.setColor(new Color(0,0,0, 0));
                    } else {
                        g.setColor(new Color(255,255,255));
                    }
                }
            }
            //stop = true;
        }

    // sets up the panel and its button
    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setBackground(new Color(0,0,0,0));
        setLayout(null);
        setOpaque(false);
    }

    // increments circle constantly
    public void setUpTimer() {
        Timer t = new Timer(15, ae -> {
            if(!stop) {
                incrementRadius();
                repaint();
                gui.recordFrame();
            }
        });
        t.start();
    }

    // increments the radius by 3 each time
    public void incrementRadius() {
        if (radius <= panelSize) {
            radius+= 3;
        }
    }

    // draws the circle
    public void drawCircle(Graphics g) {
        g.drawOval(panelSize/2 - radius/2, panelSize/2 - radius/2, radius, radius);
    }
}
