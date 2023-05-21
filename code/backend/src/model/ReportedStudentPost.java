package model;

import java.security.Timestamp;

public class ReportedStudentPost extends Post{
    private int RSP_ID;
    private int Rep_TID;

    public ReportedStudentPost(int P_ID,Timestamp P_Time,int P_UserID,int ReportCount,String PostStatus, String PostContent, int RSP_ID, int Rep_TID){
        super(P_ID,P_Time,P_UserID,ReportCount,PostStatus,PostContent);
        this.RSP_ID = RSP_ID;
        this.Rep_TID = Rep_TID;
    }

    public int getRSP_ID() {
        return RSP_ID;
    }

    public void setRSP_ID(int RSP_ID) {
        this.RSP_ID = RSP_ID;
    }

    public int getRep_TID() {
        return Rep_TID;
    }

    public void setRep_TID(int Rep_TID) {
        this.Rep_TID = Rep_TID;
    }


}
