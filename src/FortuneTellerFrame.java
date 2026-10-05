import javax.swing.*;

public class FortuneTellerFrame extends JFrame
{
    // Panels
    JPanel mainPnl;
    JPanel headerPnl;
    JPanel fortunesPnl;
    JPanel buttonsPnl;

    // Main Panel
    final int SCREEN_WIDTH = 400;
    final int SCREEN_HEIGHT = 400;

    // Header Panel
    JLabel titleLbl;
    ImageIcon icon;

    // Fortunes Panel
    JTextArea fortuneTA;
    JScrollPane fortuneSP;

    // Buttons Panel
    JButton fortuneBtn;
    JButton quitBtn;

    public FortuneTellerFrame()
    {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildHeaderPanel()
    {

    }

    private void buildFortunesPanel()
    {

    }

    private void buildButtonsPanel()
    {

    }
}
