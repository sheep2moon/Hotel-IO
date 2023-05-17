import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new BasicRoom(1));

        Hotel hotel = new Hotel(rooms);

    }
}
