package landingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class landingPageForms extends JDialog{
    private JLabel Cartlbl;
    private JLabel logoutlbl;
    private JLabel profilelbl;
    private JLabel bookListlbl;
    private JPanel mainPanel;
    private JPanel head;
    private JPanel aside;
    private JPanel books;
    private JLabel title;
    private JTextField searchbox;
    private JComboBox criteria;
    private JLabel copyright;
    private JPanel book1;
    private JPanel book2;
    private JPanel book3;
    private JPanel book4;
    private JPanel book5;
    private JPanel book6;
    private JLabel gameOfThronesGameLabel;
    private JLabel book2icon;
    private JLabel book1icon;
    private JLabel book3icon;
    private JLabel book4icon;
    private JLabel book4caption;
    private JLabel book5icon;
    private JLabel book3caption;
    private JLabel book2caption;
    private JLabel book5caption;
    private JLabel searchicon;
    private JLabel Abouticon;
    private JLabel abouticon;
    private JLabel book6icon;

    public landingPageForms(JFrame parent) {
        super(parent);
        setTitle("Home Page");
        setMinimumSize(new Dimension(1400, 800));
        //setModal(true);
        //setVisible(true);
        setLocationRelativeTo(parent);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        logoutlbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int answer = JOptionPane.showConfirmDialog(null,
                        "Are you sure, you want to sign out?", "Logout confirmation",
                        JOptionPane.YES_NO_OPTION);

                if (answer == JOptionPane.NO_OPTION) {
                    // do something
                } else if(answer == JOptionPane.YES_OPTION) {
                    File credential = new File("usercredential.txt");
                    credential.delete();
                    dispose();
                }

            }
        });
    }
}
