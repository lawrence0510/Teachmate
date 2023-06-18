package model;

public class Request {
    private int Sender_ID;
    private int Receiver_ID;
    private String Sender_Name;
    private String Receiver_Name;

    public Request(){

    }

    public Request(int Sender_ID, int Receiver_ID, String Sender_Name, String Receiver_Name){
        this.Sender_ID = Sender_ID;
        this.Receiver_ID = Receiver_ID;
        this.Sender_Name = Sender_Name;
        this.Receiver_Name = Receiver_Name;
    }

    public int getSender_ID() {
        return Sender_ID;
    }

    public void setSender_ID(int Sender_ID) {
        this.Sender_ID = Sender_ID;
    }

    public int getReceiver_ID() {
        return Receiver_ID;
    }

    public void setReceiver_ID(int Receiver_ID) {
        this.Receiver_ID = Receiver_ID;
    }

    public String getReq_Content(){
        return Req_Content;
    } 
}
