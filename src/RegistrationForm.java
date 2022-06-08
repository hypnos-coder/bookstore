import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JTextField Username;
    private JFormattedTextField Email;
    private JPasswordField Password;
    private JTextField PhoneNumber;
    private JLabel Register;
    private JButton registerButton1;
    private JButton cancelButton;
    private JPasswordField PasswordConfirmation;

    public RegistrationForm() {
        registerButton1.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

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
