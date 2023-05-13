package teachmate.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long UserID;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private int Age;

    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false)
    private String School;

    @Column(nullable = false)
    private String Region;

    @Column(nullable = false)
    private String Major;

    @Column(nullable = false)
    private String PhoneNum;

    @Column(nullable = false)
    private String Email;

    private String MBTI;

    User() {
    }

    User(Long UserID, String Password, int Age, String Gender, String School, String Region, String Major,
            String PhoneNum, String Email) {
        this.UserID = UserID;
        this.Password = Password;
        this.Age = Age;
        this.Gender = Gender;
        this.School = School;
        this.Region = Region;
        this.Major = Major;
        this.PhoneNum = PhoneNum;
        this.Email = Email;
    }

    User(Long UserID, String Password, int Age, String Gender, String School, String Region, String Major,
            String PhoneNum, String Email, String MBTI) {
        this.UserID = UserID;
        this.Password = Password;
        this.Age = Age;
        this.Gender = Gender;
        this.School = School;
        this.Region = Region;
        this.Major = Major;
        this.PhoneNum = PhoneNum;
        this.Email = Email;
        this.MBTI = MBTI;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String School) {
        this.School = School;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMBTI() {
        return MBTI;
    }

    public void setMBTI(String MBTI) {
        this.MBTI = MBTI;
    }
}
