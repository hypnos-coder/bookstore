import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegistrationForm extends  JDialog {
    private JTextField Username;
    private JFormattedTextField Email;
    private JPasswordField Password;
    private JTextField PhoneNumber;
    private JLabel Register;
    private JButton registerButton;
    private JButton cancelButton;
    private JPasswordField PasswordConfirmation;
    private JPanel registrationForm;

    public RegistrationForm(JFrame parent) throws SQLException, ClassNotFoundException {
        super(parent);
        setTitle("Register");
        setMinimumSize(new Dimension(450, 474));
        setVisible(true);
        setLocationRelativeTo(parent);
        setContentPane(registrationForm);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {


            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String Usernamevar = Username.getText();
                String Emailvar = Email.getText();
                String PhoneNumvar =PhoneNumber.getText();
                String Passwordvar = String.valueOf(Password.getPassword());
                String PasswordCvar = String.valueOf(PasswordConfirmation.getPassword());
                String message;

                Authentification authentification = new Authentification();
                try {
                     message = authentification.register(Usernamevar,Emailvar,Passwordvar,PasswordCvar,PhoneNumvar);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if(!message.equals("successfully registered")){
                    JOptionPane.showMessageDialog(parent, message);
                }



            }
        });
        cancelButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
