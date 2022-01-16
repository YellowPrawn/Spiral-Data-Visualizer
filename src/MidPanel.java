import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidPanel extends JPanel {

    int panelSize = 700;
    int radius = panelSize/7;
    int center = panelSize/2;

    public MidPanel() {
        setUpPanel();
        setUpTimer();
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
                    if (x < (center - radius/2) || x > (center + radius/2) || y < (center - radius/2) || y > (center + radius/2)) {
                        g.setColor(new Color(0,0,0));
                    } else {
                        g.setColor(new Color(0,0,0, 0));
                    }
                }
            }
        }

    // sets up the panel and its button
    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setBackground(new Color(0,0,0,0));
        setLayout(null);
        setOpaque(false);
    }

    // increments circle every 1 ms by 1
    public void setUpTimer() {
        Timer t = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                incrementRadius();
                repaint();
            }
        });
        t.start();
    }

    // increments the radius by 1 each time
    public void incrementRadius() {
        if (radius <= panelSize) {
            radius+= 1;
        }
    }

    // draws the circle
    public void drawCircle(Graphics g) {
        g.drawOval(panelSize/2 - radius/2, panelSize/2 - radius/2, radius, radius);
    }
}
