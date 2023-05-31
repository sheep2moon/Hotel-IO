import java.time.LocalDate;

public class Transaction {
    private static int nextId = 1;
    private int id;
    private int roomId;
    private String payment_details;
    private LocalDate created_at;
    private String clientId;
    private String coupon_code;
    private boolean is_finished;

    public Transaction(){
        id = nextId;
        nextId += 1;
    }

    public int getRoomId() {
        return this.roomId;
    }
    public void setRoomId(int roomId){
        this.roomId = roomId;
    }
    public void setPaymentDetails(String details,String coupon_code){
        payment_details = details;
        this.coupon_code = coupon_code;
    }
    public void setClientId(String id){
        clientId = id;
    }
    public void completeTransaction(){
        created_at = LocalDate.now();
        is_finished = true;

    }
}
