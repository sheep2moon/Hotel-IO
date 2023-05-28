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

    public void displayAvailableServices(int type){
        switch(type){
            case(1):{
                System.out.println("1. Internet");
            }break;
            case(2):{
                System.out.println("1. Internet");
                System.out.println("2. VOD");
            }break;
            case(3):{
                System.out.println("1. Internet");
                System.out.println("2. VOD");
                System.out.println("3. Konsola do gier");
            }break;
        }
    }

    public void displayPaymentForm(){

    }

    public void displaySummary(){

    }

    public void displayClientOptions(){

    }

    public void reportForm(){

    }

    public void addServicesForm(){

    }
}
