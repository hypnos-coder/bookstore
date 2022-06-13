import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegistrationForm extends JDialog {
    private JTextField tfUsername;
    private JTextField tfPhoneNumber;
    private JTextField tfEmail;
    private JTextField tfMailingAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfPasswordConfirmation;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel RegisterPanel;

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
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String Username = tfUsername.getText();
        String Password = String.valueOf(pfPassword.getPassword());
        String PasswordConfirmation = String.valueOf(pfPasswordConfirmation.getPassword());
        String PhoneNumber = tfPhoneNumber.getText();
        String Email = tfEmail.getText();
        String MailingAddress = tfMailingAddress.getText();

        if (Username.isEmpty() || Password.isEmpty() || PasswordConfirmation.isEmpty() || PhoneNumber.isEmpty() || Email.isEmpty() || MailingAddress.isEmpty()) {
            ;
        JOptionPane.showMessageDialog(this,
                "Please Enter All Fields,",
                "Try Again,",
                JOptionPane.ERROR_MESSAGE);
        return;
    }
        if(!Password.equals(PasswordConfirmation)) {
        JOptionPane.showMessageDialog(this,
                "Passwords Do Not Match",
                "Try Again",
                JOptionPane.ERROR_MESSAGE);
        return;

    }
       user = addUserToDatabase(Username, Password, PhoneNumber, Email, MailingAddress);
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to Register",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE );
        }
}
public User user;
    private User addUserToDatabase(String Username, String Password, String PhoneNumber, String Email, String MailingAddress) {
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (Username, Password, PhoneNumber, Email, MailingAddress)" +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
            preparedStatement.setString(3, PhoneNumber);
            preparedStatement.setString(4, Email);
            preparedStatement.setString(5, MailingAddress);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.Email = Email;
                user.Username = USERNAME;
                user.Password = PASSWORD;
                user.PhoneNumber = PhoneNumber;
                user.MaillingAddress = MailingAddress;
            }

            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        RegistrationForm myform = new RegistrationForm(null);
        User user = myform.user;
        if (user != null) {
            System.out.println("Successful Registration of: " + user.Username);
        }
        else {
            System.out.println("Registration Canceled");
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
