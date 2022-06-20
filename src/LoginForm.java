import landingPage.landingPageForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class LoginForm extends JDialog {
    private JTextField tfEmail_username;
    private JPasswordField pfPassword;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JButton btnOK;
    private JLabel link;

    public LoginForm(JFrame parent) {

        super(parent);
        //System.out.println("here");
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("here");
                String passwordvar = String.valueOf(pfPassword.getPassword());
                String usernamevar = tfEmail_username.getText();
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

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("here");
            }
        });
        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("here");
            }
        });
    }

}