package model;

public class Teacher extends User{
    private int T_ID;
    private String Profession;
    private int Exp_Wage;
    private String WorkExperience;
    private String Certification;
    private Float TeachingRating;

    public Teacher(int UserID, String Username, String Password, int Age, String Gender, String School, String Region, String Major,
    String PhoneNum, String Email, String MBTI,int T_ID,String Profession, int Exp_Wage, String WorkExperience, String Certification, Float TeachingRating){
        super(UserID,Username,Password,Age,Gender,School,Region,Major,PhoneNum,Email,MBTI);
        this.T_ID = T_ID;
        this.Profession = Profession;
        this.Exp_Wage = Exp_Wage;
        this.WorkExperience = WorkExperience;
        this.Certification = Certification;
        this.TeachingRating = TeachingRating;
    }
    public int getT_ID() {
        return T_ID;
    }

    public void setT_ID(int T_ID) {
        this.T_ID = T_ID;
    }
    public String Profession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }
    public int getExp_Wage() {
        return Exp_Wage;
    }

    public void setExp_Wage(int Exp_Wage) {
        this.Exp_Wage = Exp_Wage;
    }
    public String WorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String WorkExperience) {
        this.WorkExperience = WorkExperience;
    }
    public String getCertification() {
        return Certification;
    }

    public void setCertification(String Certification) {
        this.Certification = Certification;
    }
    public Float getTeachingRating() {
        return TeachingRating;
    }

    public void setTeachingRating(Float TeachingRating) {
        this.TeachingRating = TeachingRating;
    }
    
}
