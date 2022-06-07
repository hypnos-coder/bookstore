import java.sql.*;

public class Authentification {

    //created a method to give us access to the querry each time we call 'connexion'
    public Connection Connexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SQLdatabase","root","A3ecb14@");


        return connection;
        // return 'statement to execute querry
    }
    //this checks checks if the ifo that the user entered is in the database
    public boolean login(String username,String password) throws SQLException, ClassNotFoundException {
        Connection connection =  Connexion();
        // it runs and views the information
        // we used a prepared statement
        // we used "?" in place of constant for user name and password,
        // "?' 1 calls username , "?" calls password
        //no need to call querry in result when using a
        String query = "select * from userinfo where username = ? and password = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,username);
        statement.setString(2,password);
/// no need to call query when using prepared statement
        ResultSet resultSet = statement.executeQuery();
        // if statement that checks if the user is registered and returns true if username and password match
        // it returns an error if the information doesnt match or exist
        if (resultSet.next() ){
            return true;
        }
        return false;
    }

    public String register( String Username,String  Email, String Password, String PasswordConfirmation, String PhoneNumber ) throws SQLException, ClassNotFoundException {
        Connection connection =  Connexion();

        //check username Has to be unique
        // check email has to be unique
        // check password and if they match
        // query to check if username exists
        String query1 = "select * from Registration where username = ?";
        String query2= "select * from Registration where email = ?";
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
         String query = "insert into Registration values (?,?,?,?)";
         statement = connection.prepareStatement(query);
         statement.setString(1,Username);
         statement.setString(2,Email);
         statement.setString(3,Password);
         statement.setString(4,Password);
         statement.executeUpdate();


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