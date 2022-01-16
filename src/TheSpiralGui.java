import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// The main window that holds all the panels
public class TheSpiralGui {
    JFrame window;
    JLayeredPane jLayeredPane; // used to layer the diff parts of the graph (circle, spiral, axes)
    BotPanel bottomSpiralPanel; // panel of the spiral image
    MidPanel middleCirclePanel; // panel of the expanding circle
    TopPanel topAxesPanel; // panel of the axes
    JPanel visContainer; // panel that contains all of the panels
    JPanel introPanel; // starting panel

    JButton start;
    JTextArea intro;

    CardLayout cardLayout; // layout that lets you switch b/w panels

    int windowSize = 700;
    String introText = "This is a Data Visualizer of COVID cases in BC!";

    public TheSpiralGui(String province) {
        // initializing everything
        window = new JFrame();
        jLayeredPane = new JLayeredPane();
        bottomSpiralPanel = new BotPanel(province);
        middleCirclePanel = new MidPanel();
        topAxesPanel = new TopPanel();
        visContainer = new JPanel();
        introPanel = new JPanel();
        start = new JButton("Click here to start!");

        cardLayout = new CardLayout();

        // rest of the methods to set up the window
        setUpFrame();
        setUpContainer();
        setUpPanels();
    }

    // sets up the JFrame and adds the panel container to it (visContainer)
    public void setUpFrame() {
        window.setSize(windowSize, windowSize);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(visContainer);
    }

    // sets up the visCOntainr by adding the other panels to it and giving it the card layout
    public void setUpContainer() {
        visContainer.setLayout(cardLayout);
        visContainer.add(introPanel, "intro");
        visContainer.add(jLayeredPane, "layeredPanel");
        cardLayout.show(visContainer, "intro"); // switch to introPanel by key
    }

    // sets up other two panels
    public void setUpPanels() {
        setUpIntroPanel();
        setUpLayeredPanel();
    }

    // adds the intro text and start button -- on click it will show the layered panel that contains the graph
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

    // DONT change please, this orders the panels so they overlap correctly
    public void setUpLayeredPanel() {
        jLayeredPane.add(bottomSpiralPanel, 0, 0);
        jLayeredPane.add(middleCirclePanel, 1, 0);
        jLayeredPane.add(topAxesPanel, 2, 0);
    }
}
