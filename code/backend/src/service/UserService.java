package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import repository.MySQLRepository;

public class UserService {

    public boolean loginUser(User user, MySQLRepository repo) {
        String sql = "SELECT * FROM TeachMate.User WHERE Gmail = ? AND Password = ?";
        try (Connection connection = repo.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Login successful");
                return true; // User authenticated
            } else {
                System.out.println("Login failed");
                return false; // Authentication failed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Exception occurred, authentication failed
        } finally {
            try {
                repo.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }    
    

    public void saveUser(User user, MySQLRepository repo) {
        String sql = "INSERT INTO User (UserID, Username, Password, Age, Gender, School, Region, Major, PhoneNum, Gmail, MBTI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
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
                repo.closeConnection(); // 關閉連接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isUserIDExists(int userID, MySQLRepository repo) {
        try (Connection connection = repo.getConnection()) {
            String query = "SELECT COUNT(*) FROM User WHERE UserID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}