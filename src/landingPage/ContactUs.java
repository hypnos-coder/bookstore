package landingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContactUs extends JDialog {
    private JTextArea textArea1;
    private JLabel headlabel;
    private JPanel main;
    private JLabel sendicon;

    public ContactUs(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(main);
        //setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(600, 400));
        setVisible(true);
        //setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        sendicon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(parent, "Comment sent successfully ");
                dispose();
            }
        });
    }
}
