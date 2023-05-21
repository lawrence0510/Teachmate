package model;

import java.security.Timestamp;

public class Contract {
    private int C_ID;
    private int TeacherScore;
    private String C_Content;
    private int C_TeacherID;
    //TimeStamp implementation(we can add a specific time):String dateTimeString = "2023-05-20 10:30:00"; Timestamp specificTimestamp = Timestamp.valueOf(dateTimeString);
    private Timestamp Time;
    private int C_StudentID;

    public Contract(int C_ID,int TeacherScore,String C_Content,int C_TeacherID,Timestamp Time,int C_StudentID){
        this.C_ID = C_ID;
        this.TeacherScore = TeacherScore;
        this.C_Content = C_Content;
        this.C_TeacherID = C_TeacherID;
        this.Time = Time;
        this.C_StudentID = C_StudentID;
    }
    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;

    }
    
    public int getTeacherScore() {
        return TeacherScore;
    }

    public void setTeacherScore(int TeacherScore) {
        this.TeacherScore = TeacherScore;
    }
    
    public String getC_Content() {
        return C_Content;
    }

    public void setC_Content(String C_Content) {
        this.C_Content = C_Content;
    }
    
    public int getC_TeacherID() {
        return C_TeacherID;
    }

    public void setC_TeacherID(int C_TeacherID) {
        this.C_TeacherID = C_TeacherID;
    }
    
    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp Time) {
        this.Time = Time;
    }
    
    public int getC_StudentID() {
        return C_StudentID;
    }

    public void setC_StudentID(int C_StudentID) {
        this.C_StudentID = C_StudentID;
    }
}
