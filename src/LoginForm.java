import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class LoginForm extends JDialog {
    private JTextField username;
    private JPasswordField password;
    private JButton signInButton;
    private JButton cancelButton;
    private JLabel Login;
    private JPanel loginpanel;
    private JPanel title;
    private JPanel main;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setMinimumSize(new Dimension(450, 474));
        setVisible(true);
        setLocationRelativeTo(parent);
        setContentPane(loginpanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //UIManager.setLookAndFeel(new FlatLightLaf());


        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Authentification authentification = new Authentification();
                String usernamevar = username.getText();
                String passwordvar = String.valueOf(password.getPassword());

                try {
                    boolean logined = authentification.login(usernamevar,passwordvar);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
