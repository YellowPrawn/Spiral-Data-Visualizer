import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidPanel extends JPanel {
    // needs the circle logic
    // button to start sim
    int panelSize = 700;
    int radius = panelSize/2 - 100;
    JButton start;

    public MidPanel() {
        start = new JButton("Start Spiral!");
        setUpPanel();
    }

    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setLayout(null);
        setOpaque(false);
        setUpButton();
        add(start);
        start.setBounds(panelSize - 200, 40, 200, 50);
    }

    public void setUpButton() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUpTimer();
            }
        });
    }

    public void setUpTimer() {
        Timer t = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                incrementRadius();
                repaint();
            }
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g);
    }

    public void incrementRadius() {
        radius+= 1;
    }

    public void drawCircle(Graphics g) {
        g.drawOval(panelSize/2 - radius/2, panelSize/2 - radius/2, radius, radius);
    }
}
