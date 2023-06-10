package model;

public class User {
    private int UserID;

    private String Username;

    private String Password;

    private int Age;

    private String Gender;

    private String School;

    private String Region;

    private String Major;

    private String PhoneNum;

    private String Email;

    private String MBTI;

    public User() {
    	
    }

    public User(int UserID, String Username, String Password, int Age, String Gender, String School, String Region, String Major,
            String PhoneNum, String Email, String MBTI) {
        this.UserID = UserID;
        this.Username = Username;
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

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername(){
        return Username;
    }
    public void setUsername(String Username){
        this.Username = Username;
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
