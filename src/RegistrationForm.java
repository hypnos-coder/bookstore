import landingPage.landingPageForms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        setMinimumSize(new Dimension(900, 800));

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
                //create file
                try {
                    File credential = new File("usercredential.txt");

                    if (credential.createNewFile()) {
                        System.out.println("File created: " + credential.getName());

                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException error) {
                    System.out.println("An error occurred.");
                    error.printStackTrace();
                }
                try {
                    FileWriter writer = new FileWriter("usercredential.txt");
                    writer.write(Usernamevar+"\n");
                    writer.write(Emailvar+"\n");
                    writer.write(PasswordCvar+"\n");
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

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


        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("mouse clicked");
                dispose();
                Login login = new Login(null);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
