package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Post;
import model.Teacher;
import model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Contract;
import repository.MySQLRepository;

//provide methods to interact with DB,會用到在MySQLReposiory內定義的method, ex:get connection
public class UserService {

    public boolean loginUser(User user, MySQLRepository repo) {
        String sql = "SELECT * FROM TeachMate.User WHERE Gmail = ? AND Password = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Login successfully");
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

    public boolean checkUser(User user, MySQLRepository repo) {
        String sql = "SELECT UserType FROM Teachmate.User WHERE UserID = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userType = resultSet.getString("UserType");
                if (userType.equals("Student")) {
                    return false;
                } else if (userType.equals("Teacher")) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveUser(User user, MySQLRepository repo) {
        String sql = "INSERT INTO User (UserID, Username, Password, Age, Gender, School, Region, Major, PhoneNum, Gmail, MBTI, UserType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            statement.setString(12, user.getUserType());
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

    public boolean buildContract(Contract contract, MySQLRepository repo) {
        int temp_C_TeacherID = 2; // Set the teacher ID (temporarily hardcoded)
        String sql = "INSERT INTO Contract (C_ID, C_TeacherID, Time1, Time2, C_StudentID, Subject) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, contract.getC_ID());
            statement.setInt(2, temp_C_TeacherID);
            statement.setString(3, contract.getTime1());
            statement.setString(4, contract.getTime2());
            statement.setInt(5, contract.getC_StudentID());
            statement.setString(6, contract.getSubject());
            int rowsAffected = statement.executeUpdate();

            // If at least one row was affected, the contract was successfully built
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean ContractGradeComment(Contract contract, MySQLRepository repo) {
        int temp_C_ID = 100; // C_ID is a primary key can't be null so I added one here just to let the code
                             // run
        int temp_C_TeacherID = 2; // Set the teacher ID (temporarily hard)
        String temp_Time1 = "2023-06-22";
        String temp_Time2 = "2023-06-29";
        int temp_C_StudentID = 3;
        String temp_Subject = "Math";

        String sql = "INSERT INTO Contract (C_ID, TeacherScore, C_Content, C_TeacherID, Time1, Time2, C_StudentID, Subject) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, temp_C_ID);
            statement.setInt(2, contract.getTeacherScore());
            statement.setString(3, contract.getC_Content());
            statement.setInt(4, temp_C_TeacherID);
            statement.setString(5, temp_Time1);
            statement.setString(6, temp_Time2);
            statement.setInt(7, temp_C_StudentID);
            statement.setString(8, temp_Subject);
            int rowsAffected = statement.executeUpdate();
            // If at least one row was affected, the contract was successfully built
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean buildTeacherPost(Post post, MySQLRepository repo) {
        // 這裡假設是teacherID=2的老師要建立post，該老師到addpost的頁面
        int temp_TID = 2;
        post.setP_UserID(temp_TID);
        // get User's basic information to print on the post
        String sql1 = "SELECT Username, Gmail, PhoneNum, Gender, Age, MBTI, School FROM User WHERE UserID=" + temp_TID;
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql1);
                ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String username = resultSet.getString("Username");
                String gmail = resultSet.getString("Gmail");
                String phoneNum = resultSet.getString("PhoneNum");
                String gender = resultSet.getString("Gender");
                int age = resultSet.getInt("Age");
                String mbti = resultSet.getString("MBTI");
                String school = resultSet.getString("School");
                post.setPostName(username);
                post.setPostEmail(gmail);
                post.setPostPhoneNum(phoneNum);
                post.setPostGender(gender);
                post.setPostAge(age);
                post.setPostMBTI(mbti);
                post.setPostSchool(school);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // insert into the post the atributes teacher types manually on the post
        String sql2 = "INSERT INTO Post (P_ID, P_UserID, PostContent, PostSubject, PostRegion, PostMajor, PostName, PostEmail, PostPhoneNum, PostGender, PostAge, PostMBTI, PostSchool) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setInt(1, post.getP_ID());
            statement.setInt(2, post.getP_UserID());
            statement.setString(3, post.getPostContent());
            statement.setString(4, post.getPostSubject());
            statement.setString(5, post.getPostRegion());
            statement.setString(6, post.getPostMajor());
            statement.setString(7, post.getPostName());
            statement.setString(8, post.getPostEmail());
            statement.setString(9, post.getPostPhoneNum());
            statement.setString(10, post.getPostGender());
            statement.setInt(11, post.getPostAge());
            statement.setString(12, post.getPostMBTI());
            statement.setString(13, post.getPostSchool());
            int rowsAffected = statement.executeUpdate();
            // If at least one row was affected, the contract was successfully built
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean buildStudentPost(Post post, MySQLRepository repo) {
        // 這裡假設是teacherID=2的老師要建立post，該老師到addpost的頁面
        int temp_SID = 1;
        post.setP_UserID(temp_SID);
        // get User's basic information to print on the post
        String sql1 = "SELECT Username, Gmail, PhoneNum, Gender, Age, MBTI, School FROM User WHERE UserID=" + temp_SID;
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql1);
                ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String username = resultSet.getString("Username");
                String gmail = resultSet.getString("Gmail");
                String phoneNum = resultSet.getString("PhoneNum");
                String gender = resultSet.getString("Gender");
                int age = resultSet.getInt("Age");
                String mbti = resultSet.getString("MBTI");
                String school = resultSet.getString("School");
                post.setPostName(username);
                post.setPostEmail(gmail);
                post.setPostPhoneNum(phoneNum);
                post.setPostGender(gender);
                post.setPostAge(age);
                post.setPostMBTI(mbti);
                post.setPostSchool(school);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // insert into the post the atributes teacher types manually on the post
        String sql2 = "INSERT INTO Post (P_ID, P_UserID, PostContent, PostSubject, PostRegion, PostMajor, PostName, PostEmail, PostPhoneNum, PostGender, PostAge, PostMBTI, PostSchool) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql2)) {
            statement.setInt(1, post.getP_ID());
            statement.setInt(2, post.getP_UserID());
            statement.setString(3, post.getPostContent());
            statement.setString(4, post.getPostSubject());
            statement.setString(5, post.getPostRegion());
            statement.setString(6, post.getPostMajor());
            statement.setString(7, post.getPostName());
            statement.setString(8, post.getPostEmail());
            statement.setString(9, post.getPostPhoneNum());
            statement.setString(10, post.getPostGender());
            statement.setInt(11, post.getPostAge());
            statement.setString(12, post.getPostMBTI());
            statement.setString(13, post.getPostSchool());
            int rowsAffected = statement.executeUpdate();
            // If at least one row was affected, the contract was successfully built
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isContractIDExists(int contractID, MySQLRepository repo) {
        try (Connection connection = repo.getConnection()) {
            String query = "SELECT COUNT(*) FROM Contract WHERE C_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, contractID);
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

    public boolean isPostIDExists(int postID, MySQLRepository repo) {
        try (Connection connection = repo.getConnection()) {
            String query = "SELECT COUNT(*) FROM Post WHERE P_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, postID);
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

    public List<Post> filterTeachersByCriteria(String subject, String gender, String mbti, String region,
            MySQLRepository repo) {
        List<Post> filteredPosts = new ArrayList<>();
        String sql = "SELECT * FROM Post WHERE PostSubject = ? AND PostGender = ? AND PostMBTI = ? AND PostRegion = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subject);
            statement.setString(2, gender);
            statement.setString(3, mbti);
            statement.setString(4, region);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int pId = resultSet.getInt("P_ID");
                    String pTime = resultSet.getString("P_Time");
                    int pUserId = resultSet.getInt("P_UserID");
                    int reportCount = resultSet.getInt("ReportCount");
                    String postStatus = resultSet.getString("PostStatus");
                    String postContent = resultSet.getString("PostContent");
                    String postSubject = resultSet.getString("PostSubject");
                    String postRegion = resultSet.getString("PostRegion");
                    String postMajor = resultSet.getString("PostMajor");
                    String postName = resultSet.getString("PostName");
                    String postEmail = resultSet.getString("PostEmail");
                    String postPhoneNum = resultSet.getString("PostPhoneNum");
                    String postGender = resultSet.getString("PostGender");
                    int postAge = resultSet.getInt("PostAge");
                    String postMBTI = resultSet.getString("PostMBTI");
                    String postSchool = resultSet.getString("PostSchool");

                    Post newpost = new Post(pId, pTime, pUserId, reportCount, postStatus, postContent, postSubject,
                            postRegion, postMajor, postName, postEmail, postPhoneNum, postGender, postAge, postMBTI,
                            postSchool);
                    filteredPosts.add(newpost);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filteredPosts;
    }

    public List<Post> filterStudentsByCriteria(String subject, String gender, String mbti, String region,
            MySQLRepository repo) {
        List<Post> filteredPosts = new ArrayList<>();
        String sql = "SELECT * FROM Post WHERE PostSubject = ? AND PostGender = ? AND PostMBTI = ? AND PostRegion = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subject);
            statement.setString(2, gender);
            statement.setString(3, mbti);
            statement.setString(4, region);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int pId = resultSet.getInt("P_ID");
                    String pTime = resultSet.getString("P_Time");
                    int pUserId = resultSet.getInt("P_UserID");
                    int reportCount = resultSet.getInt("ReportCount");
                    String postStatus = resultSet.getString("PostStatus");
                    String postContent = resultSet.getString("PostContent");
                    String postSubject = resultSet.getString("PostSubject");
                    String postRegion = resultSet.getString("PostRegion");
                    String postMajor = resultSet.getString("PostMajor");
                    String postName = resultSet.getString("PostName");
                    String postEmail = resultSet.getString("PostEmail");
                    String postPhoneNum = resultSet.getString("PostPhoneNum");
                    String postGender = resultSet.getString("PostGender");
                    int postAge = resultSet.getInt("PostAge");
                    String postMBTI = resultSet.getString("PostMBTI");
                    String postSchool = resultSet.getString("PostSchool");

                    Post newpost = new Post(pId, pTime, pUserId, reportCount, postStatus, postContent, postSubject,
                            postRegion, postMajor, postName, postEmail, postPhoneNum, postGender, postAge, postMBTI,
                            postSchool);
                    filteredPosts.add(newpost);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filteredPosts;
    }

    public String getUserNameByEmail(String email, MySQLRepository repo) {
        try (Connection connection = repo.getConnection()) {
            String query = "SELECT Username FROM Teachmate.User WHERE Gmail = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String username = resultSet.getString("Username");
                        return username;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserTypeByEmail(String email, MySQLRepository repo) {
        try (Connection connection = repo.getConnection()) {
            String query = "SELECT UserType FROM Teachmate.User WHERE Gmail = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String userType = resultSet.getString("UserType");
                        return userType;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Map<String, Object>> getStudentInfo(String username, MySQLRepository repo) {
        List<Map<String, Object>> StudentInfo = new ArrayList<>();
        String sql = "SELECT UserType, Gender, Age, School, Major, MBTI, Gmail, PhoneNum FROM Teachmate.User WHERE Username = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Map<String, Object> student = new HashMap<>();
                    // Retrieve the values from the ResultSet and put them into the student map
                    student.put("UserType", resultSet.getString("UserType"));
                    student.put("Gender", resultSet.getString("Gender"));
                    student.put("Age", resultSet.getString("Age"));
                    student.put("School", resultSet.getString("School"));
                    student.put("Major", resultSet.getString("Major"));
                    student.put("MBTI", resultSet.getString("MBTI"));
                    student.put("Gmail", resultSet.getString("Gmail"));
                    student.put("PhoneNum", resultSet.getString("PhoneNum"));

                    // Add the student map to the studentInfo list
                    StudentInfo.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return StudentInfo;
    }

    public List<Map<String, Object>> getTeacherInfo(String username, MySQLRepository repo) {
        List<Map<String, Object>> TeacherInfo = new ArrayList<>();
        String sql = "SELECT u.UserType, u.Gender, u.Age, u.School, u.Major, u.MBTI, u.Gmail, u.PhoneNum, t.Profession, t.Exp_Wage, t.WorkExperience, t.Certification, t.TeachingRating FROM Teachmate.User as u INNER JOIN Teachmate.Teacher as t ON u.UserID = t.T_ID WHERE u.Username = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Map<String, Object> teacher = new HashMap<>();
                    // Retrieve the values from the ResultSet and put them into the student map
                    teacher.put("UserType", resultSet.getString("UserType"));
                    teacher.put("Gender", resultSet.getString("Gender"));
                    teacher.put("Age", resultSet.getString("Age"));
                    teacher.put("School", resultSet.getString("School"));
                    teacher.put("Major", resultSet.getString("Major"));
                    teacher.put("MBTI", resultSet.getString("MBTI"));
                    teacher.put("Gmail", resultSet.getString("Gmail"));
                    teacher.put("PhoneNum", resultSet.getString("PhoneNum"));
                    teacher.put("Profession", resultSet.getString("Profession"));
                    teacher.put("Exp_Wage", resultSet.getString("Exp_Wage"));
                    teacher.put("WorkExperience", resultSet.getString("WorkExperience"));
                    teacher.put("Certification", resultSet.getString("Certification"));
                    teacher.put("TeachingRating", resultSet.getString("TeachingRating"));
                    TeacherInfo.add(teacher);
                }
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                repo.closeConnection(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return TeacherInfo;
    }

    public boolean teacherinputprofession(Teacher teacher, MySQLRepository repo) {
        int temp_TID = 2;
        String sql = "UPDATE Teacher SET Profession = ? WHERE T_ID = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, teacher.getProfession());
            statement.setInt(2, temp_TID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected >0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // 關閉連接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean teacherinputworkingexperience(Teacher teacher, MySQLRepository repo) {
        int temp_TID = 2;
        String sql = "UPDATE Teacher SET WorkExperience = ? WHERE T_ID = ?";
        try (Connection connection = repo.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, teacher.getWorkExperience());
            statement.setInt(2, temp_TID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected >0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                repo.closeConnection(); // 關閉連接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}