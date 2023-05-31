import java.util.ArrayList;

enum RoomType {
    BASIC,
    COMFORT,
    DUO,

}

public class Main {
    public static void main(String[] args){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new BasicRoom(101));
        rooms.add(new BasicRoom(102));
        rooms.add(new BasicRoom(103));
        rooms.add(new ComfortRoom(121));
        rooms.add(new ComfortRoom(122));
        rooms.add(new ComfortRoom(123));
        rooms.add(new DuoRoom(141));
        rooms.add(new DuoRoom(142));
        rooms.add(new DuoRoom(143));


        Hotel hotel=Hotel.initializeHotel(rooms);



        hotel.getScreen().displayStart();

    }
}
