import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Here is the beginning of our journey");
        LoginForm loginForm = new LoginForm(null);
        Authentification authentification = new Authentification();
        boolean test = authentification.login("amen","merbelle");
        System.out.print(test);

    }
}
