import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Hotel hotel=Hotel.initializeHotel();
        hotel.getScreen().displayAvailableServices(1);
    }
}
