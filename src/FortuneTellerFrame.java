import javax.swing.*;
import java.awt.*;
import java.awt.ActiveEvent;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, topPnl, centerPnl, bottomPnl;
    JButton fortuneBtn, quitBtn;
    TextArea fortuneTA;
    JScrollPane pane;
    JLabel iconLbl;
    ImageIcon fortuneIcon;

    String[] fortunes = {"A foolish man listens to his heart. A wise man listens to cookies.",
                        "You will be hungry again in one hour.",
                        "Patience is your alley at the moment. Don’t worry!",
                        "A cynic is only a frustrated optimist.",
                        "Don’t worry about money. The best things in life are free.",
                        "If at first you don’t succeed, skydiving not for you.",
                        "Easiest way to find lost object is buy replacement.",
                        "You are cleverly disguised as responsible adult.",
                        "If a turtle doesn’t have a shell, is it naked or homeless?",
                        "An alien of some sort will be appearing to you shortly.",
                        "The fortune you seek is in another cookie.",
                        "Don’t pursue happiness – create it."};
    int curFortuneDex = -1;
    int newFortuneDex;

    public FortuneTellerFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeigh = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4,650);
        setLocation(screenWidth / 8, (screenHeigh - 650) / 2 );

        createGUI();
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createGUI()
    {
        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();

        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();
    }

    private void createCenterPnl()
    {
        fortuneTA = new TextArea(15, 60);
        pane = new JScrollPane(fortuneTA);
        centerPnl.add(pane);
    }

    private void createTopPnl()
    {
        fortuneIcon =new ImageIcon("src//images.png");

        iconLbl = new JLabel("Read your fortune if you dare!", fortuneIcon, JLabel.CENTER);
        iconLbl.setFont(new Font(Font.SERIF, Font.ROMAN_BASELINE, 25));
        iconLbl.setHorizontalTextPosition(JLabel.CENTER);
        iconLbl.setVerticalTextPosition(JLabel.BOTTOM);

        topPnl.add(iconLbl);

    }

    private void createBottomPnl()
    {

        fortuneBtn = new JButton("Read My Fortune");
        fortuneBtn.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));
        fortuneBtn.addActionListener((ActionEvent ae) -> {
                    do {
                        Random rand = new Random();
                        newFortuneDex = rand.nextInt(fortunes.length);
                    }
                    while (newFortuneDex == curFortuneDex);
                    fortuneTA.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
                    curFortuneDex = newFortuneDex;
                    fortuneTA.append(fortunes[curFortuneDex] + "\n");});


        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));



        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.setLayout(new GridLayout(1,2));
        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
    }

}
