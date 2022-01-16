import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    MidPanel midPanel;
    int panelSize = 700;
    JTextField jan;
    JTextField apr;
    JTextField jul;
    JTextField oct;

    public TopPanel() {
        midPanel = new MidPanel();
        setUpPanel();
    }

    public void setUpPanel() {
        setSize(panelSize, panelSize);
        setLayout(null);
        setOpaque(false);
        setUpTimer();
        setUpTexts();
    }

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

    public void setUpTimer() {
        Timer t = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        });
        t.start();
    }

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
