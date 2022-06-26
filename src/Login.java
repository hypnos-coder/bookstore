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
import java.sql.SQLException;

public class Login extends JFrame{
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
        //super(parent);
        setTitle("Login");
        setContentPane(signinpanel);
        //setPreferredSize(new Dimension(800, 800));
        setMinimumSize(new Dimension(600, 400));
        setVisible(true);
       // setModal(true);
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
                    writer.write(usernamevar+"\n");

                    writer.write(authentification.encrypt(passwordvar,"philomath")+"\n");
                    writer.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
                landingPageForms land = new landingPageForms(null);
                land.setVisible(true);

            }


        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                RegistrationForm registrationForm = new RegistrationForm(null);
                registrationForm.setVisible(true);

            }
        });
    }
}
