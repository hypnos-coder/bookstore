import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Base64;

public class Authentification {
    private static SecretKeySpec secretKey;
    private static byte[] key;

    //created a method to give us access to the querry each time we call 'connexion'

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
        statement.setString(3,encrypt(password,"philomath"));
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
         statement.setString(2,encrypt(Password,"philomath"));

         statement.setString(3,PhoneNumber);
         statement.setString(4,Email);
         statement.setString(5,MailingAdress);
         statement.executeUpdate();

        System.out.println("here");
        return "successfully registered";
    }
    public static void setKey(final String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(final String strToEncrypt, final String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder()
                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(final String strToDecrypt, final String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder()
                    .decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
