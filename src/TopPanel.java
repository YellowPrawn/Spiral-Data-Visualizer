import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// top panel containing the axes
public class TopPanel extends JPanel {
    int panelSize = 700;
    JTextField jan;
    JTextField apr;
    JTextField jul;
    JTextField oct;

    public TopPanel() {
        setUpPanel();
    }

    // sets up the panel
    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setLayout(null);
        setOpaque(false);
        setUpTimer();
        setUpTexts();
    }

    // sets up the axes labels
    public void setUpTexts() {
        jan = new JTextField("January");
        apr = new JTextField("April");
        jul = new JTextField("July");
        oct = new JTextField("October");
        add(jan);
        add(apr);
        add(jul);
        add(oct);
        jan.setBounds(panelSize/2 + 40, 40, 80, 30);
        apr.setBounds(panelSize - 40,panelSize/2 + 40, 80, 30);
        jul.setBounds(panelSize/2 + 40, panelSize - 40, 80, 30);
        oct.setBounds(40, panelSize/2 + 40, 80, 30);


    }

    // sets up a timer to redraw the axes
    public void setUpTimer() {
        Timer t = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        });
        t.start();
    }

    // the following two methods draw the lines of the axes
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAxes(g);
    }

    public void drawAxes(Graphics g) {
        g.drawLine(0, panelSize/2, panelSize, panelSize/2);
        g.drawLine(panelSize/2, 0, panelSize/2, panelSize);
    }
}
