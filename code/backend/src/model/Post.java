package model;

import java.security.Timestamp;

public class Post {
    private int P_ID;
    private Timestamp P_Time;
    private int P_UserID;
    private int ReportCount;
    private String PostStatus;
    private String PostContent;

    public Post(int P_ID,Timestamp P_Time,int P_UserID,int ReportCount,String PostStatus, String PostContent){
        this.P_ID = P_ID;
        this.P_Time = P_Time;
        this.P_UserID = P_UserID;
        this.ReportCount = ReportCount;
        this.PostStatus = PostStatus;
        this.PostContent = PostContent;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public Timestamp getP_Time() {
        return P_Time;
    }

    public void setP_Time(Timestamp P_Time) {
        this.P_Time = P_Time;
    }

    public int getP_UserID() {
        return P_UserID;
    }

    public void setP_UserID(int P_User_ID) {
        this.P_UserID = P_User_ID;
    }

    public int ReportCount() {
        return ReportCount;
    }

    public void setReportCount(int ReportCount) {
        this.ReportCount = ReportCount;
    }

    public String getPostStatus() {
        return PostStatus;
    }

    public void setPostStatus(String PostStatus) {
        this.PostStatus = PostStatus;
    }

    public String getPostContent() {
        return PostContent;
    }

    public void setPostContent(String PostContent) {
        this.PostContent = PostContent;
    }
}
