import java.util.ArrayList;

public class Hotel {
    private static Hotel instance=null;
    private ArrayList<Room> rooms;
    private Transaction current_transaction;
    private ArrayList<Transaction> transactions;
    private Screen screen;

    public static Hotel initializeHotel(){
        if(instance==null){
            return new Hotel();
        }
        else return instance;
    }


    private Hotel() {
        rooms=new ArrayList<>();
        transactions=new ArrayList<>();
        screen=new Screen();
        instance=this;
    }

    public Screen getScreen() {
        return screen;
    }
}
