import javax.crypto.Cipher;

import java.security.*;
import java.sql.*;

public class Authentification {

    //created a method to give us access to the querry each time we call 'connexion'
    public String encription(String password) throws Exception {
        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //Adding data to the cipher
        byte[] input = password.getBytes();
        cipher.update(input);
        byte[] cipherText = cipher.doFinal();

        return cipherText.toString();
    }
    public Connection Connexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        return DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","merbelle");
        // return 'statement to execute querry
    }
    //this checks checks if the ifo that the user entered is in the database
    public String login(String username_email, String password) throws SQLException, ClassNotFoundException {
        Connection connection =  Connexion();
        // it runs and views the information
        // we used a prepared statement
        // we used "?" in place of constant for username and password,
        // "?' 1 calls username_email , "?" calls password
        //no need to call query in result when using a
        String query = "select * from userdb where useremail = ? or username = ? and userpassword = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,username_email);
        statement.setString(2,username_email);
        statement.setString(3,password);
/// no need to call query when using prepared statement
        ResultSet resultSet = statement.executeQuery();
        // if statement that checks if the user is registered and returns true if username_email and password match
        // it returns an error if the information doesnt match or exist
        if (resultSet.next()){
            return "success";
        }
        return "bad credential";
    }

    public String register( String Username,String  Email, String Password, String PasswordConfirmation, String PhoneNumber, String MailingAdress ) throws SQLException, ClassNotFoundException {
        Connection connection =  Connexion();

        //check username Has to be unique
        // check email has to be unique
        // check password and if they match
        // query to check if username exists
        String query1 = "select * from userdb where username = ?";
        String query2= "select * from userdb where useremail = ?";
        PreparedStatement statement = connection.prepareStatement(query1);
        statement.setString( 1, Username);
        ResultSet resultSet = statement.executeQuery();
         //
         if(resultSet.next()) {
             return("username already exists ");
         }
         statement = connection.prepareStatement(query2);
         statement.setString(1,Email);
         resultSet = statement.executeQuery();
         if (resultSet.next()){
             return "sorry, a user with that email already exists";
         }
         if (!Password.equals(PasswordConfirmation)){
             return "Enter a matching password";
         }
         String query = "insert into userdb values (?,?,?,?,?)";
         statement = connection.prepareStatement(query);
         statement.setString(1,Username);
         statement.setString(2,Password);

         statement.setString(3,PhoneNumber);
         statement.setString(4,Email);
         statement.setString(5,MailingAdress);
         statement.executeUpdate();

        System.out.println("here");
        return "successfully registered";




    }
}
/*
* Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","merbelle");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from student");
        while (resultSet.next())
            System.out.println(resultSet.getString(1)+
                    "\t"+resultSet.getString(2)
                    +"\t"+resultSet.getString(3)
                    +"\t"+resultSet.getString(4)
                    +"\t"+resultSet.getString(5)
                    +"\t"+resultSet.getString(6)
                    +"\t"+resultSet.getString(7)
                    +"\t"+resultSet.getString(8));
        connection.close();
        System.out.println(System.getProperty("user.name"));*/