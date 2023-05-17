package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class MySQLRepository {
    private String url = "jdbc:mysql://localhost:3306/Teachmate";
    private String username = "root";
    private String password = "25352Riigdii";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws SQLException {
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

    public void saveUser(User user) {
        String sql = "INSERT INTO users (UserID, Username, Password, Age, Gender, School, Region, Major, PhoneNum, Email, MBTI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, user.getUserID());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getGender());
            statement.setString(6, user.getSchool());
            statement.setString(7, user.getRegion());
            statement.setString(8, user.getMajor());
            statement.setString(9, user.getPhoneNum());
            statement.setString(10, user.getEmail());
            statement.setString(11, user.getMBTI());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeStatement(statement);
                closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    


}
