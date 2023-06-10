package model;

import java.security.Timestamp;

public class Post {
    private int P_ID;
    private String P_Time;
    private int P_UserID;
    private int ReportCount;
    private String PostStatus;
    private String PostContent;
    private String PostSubject;
    private String PostRegion;
    private String PostMajor;
    private String PostName;
    private String PostEmail;
    private String PostPhoneNum;
    private String PostGender;
    private int PostAge;
    private String PostMBTI;
    private String PostSchool;

    public Post(){

    }
    
    public Post(int pId, String pTime, int pUserId, int reportCount, String postStatus, String postContent, String postSubject, String postRegion, String postMajor, String postName, String postEmail, String postPhoneNum, String postGender, int postAge, String postMBTI, String postSchool) {
        this.P_ID = pId;
        this.P_Time = pTime;
        this.P_UserID = pUserId;
        this.ReportCount = reportCount;
        this.PostStatus = postStatus;
        this.PostContent = postContent;
        this.PostMajor = postMajor;
        this.PostRegion = postRegion;
        this.PostSubject = postSubject;
        this.PostName = postName;
        this.PostEmail = postEmail;
        this.PostPhoneNum = postPhoneNum;
        this.PostGender = postGender;
        this.PostAge = postAge;
        this.PostMBTI = postMBTI;
        this.PostSchool = postSchool;
    }
    
    
    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int P_ID) {
        this.P_ID = P_ID;
    }

    public String getP_Time() {
        return P_Time;
    }

    public void setP_Time(String P_Time) {
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

    public String getPostSubject() {
        return PostSubject;
    }

    public void setPostSubject(String PostSubject) {
        this.PostSubject = PostSubject;
    }

    public String getPostRegion() {
        return PostRegion;
    }

    public void setPostRegion(String PostRegion) {
        this.PostRegion = PostRegion;
    }

    public String getPostGender() {
        return PostGender;
    }

    public void setPostGender(String PostGender) {
        this.PostGender = PostGender;
    }

    public String getPostMBTI() {
        return PostMBTI;
    }

    public void setPostMBTI(String PostMBTI) {
        this.PostMBTI = PostMBTI;
    }

    public String getPostMajor() {
        return PostMajor;
    }

    public void setPostMajor(String PostMajor) {
        this.PostMajor = PostMajor;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String PostName) {
        this.PostName = PostName;
    }

    public String getPostEmail() {
        return PostEmail;
    }

    public void setPostEmail(String PostEmail) {
        this.PostEmail = PostEmail;
    }

    public String getPostPhoneNum() {
        return PostPhoneNum;
    }

    public void setPostPhoneNum(String PostPhoneNum) {
        this.PostPhoneNum = PostPhoneNum;
    }

    public int getPostAge() {
        return PostAge;
    }

    public void setPostAge(int PostAge) {
        this.PostAge = PostAge;
    }

    public String getPostSchool() {
        return PostSchool;
    }

    public void setPostSchool(String PostSchool) {
        this.PostSchool = PostSchool;
    }
    
}
