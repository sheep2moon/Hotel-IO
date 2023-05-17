import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;
    private Transaction current_transaction;
    private ArrayList<Transaction> transactions;
    private Screen screen;

    public Hotel(ArrayList<Room> rooms) {
        this.rooms = rooms;
        screen = new Screen();
    }
}
