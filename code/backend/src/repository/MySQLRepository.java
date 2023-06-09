package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//handle the connection to the database
public class MySQLRepository {
    private String url = "jdbc:mysql://localhost:3306/Teachmate?useSSL=false";
    private String username = "root";
    private String password = "25352Riigdii";
    private Connection connection;
    //establish connection with DB
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    //close is to check if exist, then relese the resources associated with it
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
    }

    public void closeStatement(PreparedStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
    }
}
