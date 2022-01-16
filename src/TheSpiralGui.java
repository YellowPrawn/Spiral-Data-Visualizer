import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheSpiralGui {
    JFrame window;
    JLayeredPane jLayeredPane;
    BotPanel bottomSpiralPanel;
    MidPanel middleCirclePanel;
    TopPanel topAxesPanel;
    JPanel visContainer;
    JPanel introPanel;

    JButton start;
    JTextArea intro;

    CardLayout cardLayout;

    int windowSize = 700;
    String introText = "This is a Data Visualizer of COVID cases in BC!";

    public TheSpiralGui() {
        window = new JFrame();
        jLayeredPane = new JLayeredPane();
        bottomSpiralPanel = new BotPanel();
        middleCirclePanel = new MidPanel();
        topAxesPanel = new TopPanel();
        visContainer = new JPanel();
        introPanel = new JPanel();
        start = new JButton("Click here to start!");

        cardLayout = new CardLayout();

        setUpFrame();
        setUpContainer();
        setUpPanels();
    }

    public void setUpFrame() {
        window.setSize(windowSize, windowSize);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(visContainer);
    }

    public void setUpContainer() {
        visContainer.setLayout(cardLayout);
        visContainer.add(introPanel, "intro");
        visContainer.add(jLayeredPane, "layeredPanel");
        cardLayout.show(visContainer, "intro");
    }

    public void setUpPanels() {
        setUpIntroPanel();
        setUpLayeredPanel();
    }

    public void setUpIntroPanel() {
        intro = new JTextArea(introText);
        introPanel.add(start);
        introPanel.add(intro);
        intro.setBounds(windowSize/10, windowSize/10, 300, 100);
        start.setBounds(windowSize/2, windowSize/2, 200, 100);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(visContainer, "layeredPanel");
            }
        });
    }

    public void setUpLayeredPanel() {
        jLayeredPane.add(bottomSpiralPanel, 0, 0);
        jLayeredPane.add(middleCirclePanel, 1, 0);
        jLayeredPane.add(topAxesPanel, 2, 0);
    }
}
