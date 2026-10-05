import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class FortuneTellerFrame extends JFrame
{
    // Panels
    JPanel mainPnl;
    JPanel headerPnl;
    JPanel fortunesPnl;
    JPanel buttonsPnl;

    // Main Panel
    final int SCREEN_WIDTH = 450;
    final int SCREEN_HEIGHT = 750;

    // Header Panel
    JLabel titleLbl;
    ImageIcon icon;

    // Fortunes Panel
    JTextArea fortuneTA;
    JScrollPane fortuneSP;

    // Buttons Panel
    JButton fortuneBtn;
    JButton quitBtn;

    // Fonts
    File headerFontFile = new File("src/KiwiSoda.ttf");
    Font headerFont = Font.createFont(Font.TRUETYPE_FONT, headerFontFile).deriveFont(Font.PLAIN, 48f);
    File fortunesFontFile = new File("src/Ancient Medium.ttf");
    Font fortunesFont = Font.createFont(Font.TRUETYPE_FONT, fortunesFontFile).deriveFont(Font.PLAIN, 24f);
    File buttonsFontFile = new File("src/Always in the Star.ttf");
Font buttonsFont = Font.createFont(Font.TRUETYPE_FONT, buttonsFontFile).deriveFont(Font.PLAIN, 24f);

    public FortuneTellerFrame() throws IOException, FontFormatException {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        // Build Body Panels
        buildHeaderPanel();
        mainPnl.add(headerPnl, BorderLayout.NORTH);

        buildFortunesPanel();
        mainPnl.add(fortunesPnl, BorderLayout.CENTER);

        buildButtonsPanel();
        mainPnl.add(buttonsPnl, BorderLayout.SOUTH);

        // Setup Main Panel
        add(mainPnl);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void buildHeaderPanel()
    {
        headerPnl = new JPanel();
        icon = new ImageIcon("src/icon.png");                           // Image created by Levon Howard
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titleLbl.setFont(headerFont);
        titleLbl.setForeground(Color.decode("#7818CC"));

        headerPnl.add(titleLbl);
    }

    private void buildFortunesPanel()
    {
        fortunesPnl = new JPanel();
        fortuneTA = new JTextArea(10, 20);
        fortuneTA.setFont(fortunesFont);
        fortuneSP = new JScrollPane(fortuneTA);

        fortunesPnl.add(fortuneSP);
    }

    private void buildButtonsPanel()
    {
        buttonsPnl = new JPanel();
        buttonsPnl.setLayout(new GridLayout(1, 2));

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit!");

        fortuneBtn.setFont(buttonsFont);
        quitBtn.setFont(buttonsFont);

        buttonsPnl.add(fortuneBtn);
        buttonsPnl.add(quitBtn);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
