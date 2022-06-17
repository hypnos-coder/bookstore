package landingPage;

import javax.swing.*;
import java.awt.*;

public class landingPageForms extends JDialog{
    private JLabel Cartlbl;
    private JLabel logoutlbl;
    private JLabel profilelbl;
    private JLabel bookListlbl;
    private JLabel book1lbl;
    private JLabel book2lbl;
    private JLabel book3lbl;
    private JLabel book4lbl;
    private JLabel book5lbl;
    private JLabel book6lbl;
    private JPanel mainPanel;
    private JPanel head;
    private JPanel aside;
    private JPanel books;
    private JLabel title;
    private JTextField searchbox;
    private JComboBox criteria;
    private JLabel searchlabel;
    private JLabel copyright;

    public landingPageForms(JFrame parent) {
        super(parent);
        setTitle("Login");
        setMinimumSize(new Dimension(800, 600));
        setVisible(true);
        setLocationRelativeTo(parent);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }
}
