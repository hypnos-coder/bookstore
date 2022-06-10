import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JButton okButton;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    
    

    /*btnOk.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = tfEmail.getText();
            String password = String.valueOf(pfPassword.getPassword());

            user = getAuthenticatedUser(email, password);
            
            public user user;
    private user getAuthentication(String email, String password) {
        user user = null;
        return user;


            if (user != null) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(LoginForm.this,
                        "Email or Password Invalid",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        } */
}

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
    }


}
/*public User user;
private User getAuthenticatedUser(String email, String password){
    User user = null;

    String jdbc;
    final String DB_URL = jdbc:mysql://localhost:3306""
    final String USERNAME = "root";
    final String PASSWORD = "Agagod12!@";

    try{
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        //Connected successfully

        Statement stmt = conn.createStatement();
        String sql = "SELECT*FROM users WHERE email=? AND password=?";
        preparedStatement preparedStament = conn.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();




    }catch(Exception e){
        e.printStackTrace();
    }


    return user;
}

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
    }
} */
