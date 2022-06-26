package landingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profil extends JFrame{
    private JPanel rootpanel;
    private JPanel info;
    private JLabel backp;
    private JLabel emailp;
    private JLabel phonenumberp;
    private JLabel mailingp;
    private JLabel profilep;
    private JLabel usernamep;

    public Profil(String username, String email, String phone, String mailing){
        setMinimumSize(new Dimension(600, 400));
        setContentPane(rootpanel);
       // setVisible(true);
        setName("Profile");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(((int) d.getWidth() - 500) / 2, ((int) d.getHeight() - 600) / 2, 500, 600);
        usernamep.setText("Username");
        emailp.setText("Email");
        phonenumberp.setText("Phone number");
        mailingp.setText("Mailing address");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        backp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                landingPageForms landingPageForms = new landingPageForms(null);
                landingPageForms.setVisible(true);
                dispose();

            }
        });
    }
}
