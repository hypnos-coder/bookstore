package landingPage;

import javax.swing.*;
import java.awt.*;

public class AboutPage extends JDialog {
    private JPanel main;
    private JLabel headlabel;
    private JTextPane thisProjectIsTheTextPane;
    public AboutPage(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(main);
        //setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(600, 400));
        setVisible(true);
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
