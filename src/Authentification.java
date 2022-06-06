import java.sql.*;

public class Authentification {

    //created a method to give us access to the querry each time we call 'connexion'
    public Connection Connexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","merbelle");


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
        String querie = "select * from userinfo where username = ? and password = ? ";
        PreparedStatement statement = connection.prepareStatement(querie);
        statement.setString(1,username);
        statement.setString(2,password);
/// no need to call qurry when using prepared statement
        ResultSet resultSet = statement.executeQuery();
        // if statement that checks if the user is registered and returns true if username and password match
        // it returns an error if the information doesnt match or exist
        if (resultSet.next() ){
            return true;
        }
        return false;
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