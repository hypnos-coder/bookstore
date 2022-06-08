import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Here is the beginning of our journey");
        //LoginForm loginForm = new LoginForm(null);
        Authentification authentification = new Authentification();
        //boolean test = authentification.login("amen","merbelle");
        //String test = authentification.register("hafsa9","hafsabadullahi1@gmail.com","password123","password123", "6123091958");
        //System.out.print(test);
        RegistrationForm registrationForm = new RegistrationForm(null);
        registrationForm.setVisible(true);

    }
}
