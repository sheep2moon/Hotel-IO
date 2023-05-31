import java.util.ArrayList;

public class Hotel {
    private static Hotel instance=null;
    private ArrayList<Room> rooms;
    Transaction current_transaction;
    private ArrayList<Transaction> transactions;
    private Screen screen;

    public static Hotel initializeHotel(ArrayList<Room> rooms){
        if(instance==null){
            return new Hotel(rooms);
        }
        else return instance;
    }


    private Hotel(ArrayList<Room> rooms) {
        this.rooms = new ArrayList<>(rooms);
        transactions=new ArrayList<>();
        screen=new Screen();
        screen.hotel = this;
        instance=this;
    }

    public Screen getScreen() {
        return screen;
    }

    public void initTransaction() {
        this.current_transaction = new Transaction();
    }

    public void clearCurrentTransaction() {
        this.current_transaction = null;
    }

    public void checkin() {
        Client client = new Client(current_transaction.getRoomId(), current_transaction,1);
        Room clientRoom = getRoomById(current_transaction.getRoomId());
        clientRoom.key.attachClient(client);
        current_transaction.completeTransaction();
        transactions.add(current_transaction);
    }
    public void checkout(int roomId) {
        Room checkoutRoom = getRoomById(roomId);
        checkoutRoom.isReady = false;
        checkoutRoom.key.detachClient();
    }
    public Room getRoomById(int roomId) {
        Room res_room = null;
        for (Room room : this.rooms) {
            if (room.key.getId() == roomId) {
                res_room = room;
                break;
            }
        }
        return res_room;
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
