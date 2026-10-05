import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    // Panels
    JPanel mainPnl;
    JPanel headerPnl;
    JPanel fortunesPnl;
    JPanel buttonsPnl;

    // Screen dimensions / Main Panel
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    Image img = kit.getImage("src/icon.png");

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

    // Fortune Selection
    Random rnd = new Random();
    int fortuneIndex = -1;
    int lastFortuneIndex = -1;
    String[] fortunes =
    {
        "Your finances will be a key to your financial future.",
        "Borrow money from a pessimist-- they don't expect it back.",
        "Ignore your last fortune.",
        "Beware the bear wrapped in a fish's skin.",
        "The cards say... Huh, I must have grabbed the wrong deck, but you\ngot a straight, which is pretty good, right?",
        "It appears you are made of the combined effort of unimaginable\npower and energy and eons old stardust. The mere fact you are\nhere is a miracle... but so is dirt so don't get too full of yourself.",
        "One of your friends plans to stab you in the back, or is it, plans\nto nab a sale item off the rack? The second part is a bit hazy...",
        "Ah yes, a very handsome ghost is in your future. He is headless\nover heels for you.",
        "I see a very unfortunate cooking accident in the future. How\nattached to your left foot are you?",
        "You will achieve inner peace. Outwardly, you will still scream\ninto pillows.",
        "You will find the thing you lost. It will be exactly where you\nleft it five minutes ago.",
        "Expect good news. Also expect a follow‑up that says 'just kidding.'",
        "Error 404: Fortune not found. Try again later."
    };

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
        setSize((screenWidth / 4) * 3, (screenHeight / 4) * 3); // Panel should take up 75% of screen width/height
        setLocation(screenWidth / 8, screenHeight / 8); // Center panel
        setIconImage(img);
        setTitle("Fortune Teller");
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
        fortuneTA = new JTextArea(20, 40);
        fortuneTA.setEditable(false);
        fortuneTA.setFont(fortunesFont);
        fortuneSP = new JScrollPane(fortuneTA);

        fortunesPnl.add(fortuneSP);
    }

    private void buildButtonsPanel()
    {
        buttonsPnl = new JPanel();
        buttonsPnl.setLayout(new GridLayout(1, 2));

        // Fortunes Button
        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(buttonsFont);
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            do
            {
                fortuneIndex = rnd.nextInt(fortunes.length);
            } while (fortuneIndex == lastFortuneIndex);

            fortuneTA.append(fortunes[fortuneIndex] + "\n\n");
            lastFortuneIndex = fortuneIndex;
        });

        // Quit Button
        quitBtn = new JButton("Quit!");
        quitBtn.setFont(buttonsFont);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonsPnl.add(fortuneBtn);
        buttonsPnl.add(quitBtn);
    }
}
