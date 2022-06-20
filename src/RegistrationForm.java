import landingPage.landingPageForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class RegistrationForm extends JDialog {
    private JTextField tfUsername;
    private JTextField tfPhoneNumber;
    private JTextField tfEmail;
    private JTextField tfMailingAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfPasswordConfirmation;
    private JButton btnRegister;
    private JButton btnCancel;
    private JLabel head;
    private JPanel RegisterPanel;
    private JLabel link;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Create A New Account");
        setContentPane(RegisterPanel);
        //setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(800, 800));
        setMaximumSize(new Dimension(800, 800));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setVisible(true);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usernamevar = tfUsername.getText();
                String Emailvar = tfEmail.getText();
                String PhoneNumvar =tfPhoneNumber.getText();
                String Passwordvar = String.valueOf(pfPassword.getPassword());
                String PasswordCvar = String.valueOf(pfPasswordConfirmation.getPassword());
                String Mailingadressvar = tfMailingAddress.getText();
                String message;

                Authentification authentification = new Authentification();
                try {
                    if (Usernamevar.isEmpty() || Emailvar.isEmpty() ||
                            PhoneNumvar.isEmpty() ||Passwordvar.isEmpty() ||
                            PasswordCvar.isEmpty() || Mailingadressvar.isEmpty()){
                        message = "All field are required";

                    }else {
                        message = authentification.register(Usernamevar, Emailvar, Passwordvar, PasswordCvar, PhoneNumvar, Mailingadressvar);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if(!message.equals("successfully registered")){
                    JOptionPane.showMessageDialog(parent, message);
                    return;
                }
                //landingPageForms land = new landingPageForms(null);
                Login loginForm = new Login(null);
                dispose();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
