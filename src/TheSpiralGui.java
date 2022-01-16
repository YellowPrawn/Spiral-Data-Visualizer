import javax.swing.*;

// The main window that holds all the panels
public class TheSpiralGui {
    JFrame window;
    JLayeredPane jLayeredPane; // used to layer the diff parts of the graph (circle, spiral, axes)
    BotPanel bottomSpiralPanel; // panel of the spiral image
    MidPanel middleCirclePanel; // panel of the expanding circle
    TopPanel topAxesPanel; // panel of the axes

    int windowSize = 700;

    public TheSpiralGui(String province) {
        // initializing everything
        window = new JFrame();
        jLayeredPane = new JLayeredPane();
        bottomSpiralPanel = new BotPanel(province);
        middleCirclePanel = new MidPanel();
        topAxesPanel = new TopPanel();

        // rest of the methods to set up the window
        setUpLayeredPanel();
        setUpFrame();
    }

    // sets up the JFrame and adds the panel container to it (visContainer)
    public void setUpFrame() {
        window.setSize(windowSize, windowSize);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.add(jLayeredPane);
    }

    // DONT change please, this orders the panels so they overlap correctly
    public void setUpLayeredPanel() {
        jLayeredPane.add(bottomSpiralPanel, 0, 0);
        jLayeredPane.add(middleCirclePanel, 1, 0);
        jLayeredPane.add(topAxesPanel, 2, 0);
    }
}
