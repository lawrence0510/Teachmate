package model;

import java.security.Timestamp;

public class ReportedTeacherPost extends Post{
    private int RTP_ID;
    private int Rep_SID;

    public ReportedTeacherPost(int P_ID,String P_Time,int P_UserID,int ReportCount,String PostStatus, String PostContent, int RTP_ID, int Rep_SID){
        super(P_ID,P_Time,P_UserID,ReportCount,PostStatus,PostContent);
        this.RTP_ID = RTP_ID;
        this.Rep_SID = Rep_SID;
    }

    public int getRTP_ID() {
        return RTP_ID;
    }

    public void setRTP_ID(int RTP_ID) {
        this.RTP_ID = RTP_ID;
    }

    public int getRep_SID() {
        return Rep_SID;
    }

    public void setRep_SID(int Rep_SID) {
        this.Rep_SID = Rep_SID;
    }
    
}
