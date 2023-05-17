import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    private Hotel hotel;

    public void displayStart(){
        System.out.println("Witaj w Hotelu X");
    }
    public void displayRoomTypes(){
        System.out.println("1. Basic Room \n");
        System.out.println("2. Comfort Room \n");
        System.out.println("3. Duo Room \n");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();
        displayAvailableRooms(Integer.parseInt(userChoice));
    }
    public void displayAvailableRooms(int type){

    }

}
