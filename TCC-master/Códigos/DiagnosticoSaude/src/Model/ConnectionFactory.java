package Model;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory 
{ 
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "diagnostico_de_saude";
    private static final String HOST = "localhost";

    public static Connection getConnection() throws SQLException
    { 
        return DriverManager.getConnection("jdbc:mysql://"+ConnectionFactory.HOST+"/"+ConnectionFactory.DATABASE+"?useSSL=false", ConnectionFactory.USER, ConnectionFactory.PASSWORD);
    }
}