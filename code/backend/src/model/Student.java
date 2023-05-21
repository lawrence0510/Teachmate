package model;

public class Student extends User{
    private int S_ID;

    public Student(Long UserID, String Username, String Password, int Age, String Gender, String School, String Region, String Major,
    String PhoneNum, String Email, String MBTI,int S_ID){
        super(UserID,Username,Password,Age,Gender,School,Region,Major,PhoneNum,Email,MBTI);
        this.S_ID = S_ID;
    }
    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int S_ID) {
        this.S_ID = S_ID;
    }
}
