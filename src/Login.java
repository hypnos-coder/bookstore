import landingPage.landingPageForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JDialog{
    private JPanel signinpanel;
    private JPanel head;
    private JLabel headlabel;
    private JTextField pfusername_email;
    private JPasswordField tfpassword;
    private JLabel password;
    private JLabel username_email;
    private JLabel link;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel body;
    private JPanel main;
    private JPanel buttonfield;

    public Login(JFrame parent){
        super(parent);
        setTitle("Create A New Account");
        setContentPane(signinpanel);
        //setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("here");
                String passwordvar = String.valueOf(tfpassword.getPassword());
                String usernamevar = pfusername_email.getText();
                String message = "";

                Authentification authentification = new Authentification();
                try {
                    if (usernamevar.isEmpty() || passwordvar.isEmpty()) {
                        message = "All field are required";

                    } else {
                        message = authentification.login(usernamevar, passwordvar);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if (!message.equals("success")) {
                    JOptionPane.showMessageDialog(parent, message);
                    return;
                }
                landingPageForms land = new landingPageForms(null);
                dispose();
            }


        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

    }
}
