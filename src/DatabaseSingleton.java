import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {

    private static DatabaseSingleton instance;
    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/sql_store2";
    private String user = "root";
    private String password = "Ivan123456789";

    private DatabaseSingleton(){
        try{
            this.connection = DriverManager.getConnection(url, user, password);

        } catch(SQLException e){
            throw new RuntimeException("Unable to connect to database", e);
        }
    }

    public static DatabaseSingleton getInstance(){
        if (instance == null){
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
    
}
