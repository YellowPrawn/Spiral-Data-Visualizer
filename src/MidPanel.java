import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidPanel extends JPanel {

    int panelSize = 700;
    int radius = panelSize/7;
    JButton start;

    public MidPanel() {
        start = new JButton("Start Spiral!");
        setUpPanel();
    }

    // sets up the panel and its button
    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setLayout(null);
        setOpaque(false);
        setUpButton();
        add(start);
        start.setBounds(panelSize - 200, 40, 200, 50);
    }

    // button on-click sets up the timer to start moving the circle
    public void setUpButton() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpTimer();
            }
        });
    }

    // increments circle every 1 ms by 1
    public void setUpTimer() {
        Timer t = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                incrementRadius();
                repaint();
            }
        });
        t.start();
    }

    // draws the circle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g);
    }

    // increments the radius by 5 each time
    public void incrementRadius() {
        radius+= 1;
    }

    // draws the circle
    public void drawCircle(Graphics g) {
        g.drawOval(panelSize/2 - radius/2, panelSize/2 - radius/2, radius, radius);
    }
}
