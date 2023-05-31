import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    public Hotel hotel;
    private static final Scanner scanner = new Scanner(System.in);



    public void displayStart(){
        System.out.println("\n---------------------------");
        System.out.println("Witaj w Hotelu X");
        int currentRoomId = 0;
        if (this.hotel.current_transaction != null){
            currentRoomId = this.hotel.current_transaction.getRoomId();
        }
        System.out.println("1. Wynajęcie pokoju");
        if (currentRoomId != 0) System.out.println("2. * Włóż kartę swojego pokoju *");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice){
            case (1) -> displayRoomTypes();
            case (2) -> {
                if (currentRoomId != 0){
                    System.out.println("Czytam kartę... ");
                    displayClientOptions(currentRoomId);
                }
            }
            default -> {
                System.out.println("Przepraszamy, wystąpił błąd.\n *Restart systemu*");
                displayLoading(100);
            }
        }

    }
    public void displayRoomTypes(){
        System.out.println("Wybierz typ pokoju:");
        System.out.println("1. Basic Room ");
        System.out.println("2. Comfort Room ");
        System.out.println("3. Duo Room ");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice) {
            case (1) -> displayAvailableRooms(RoomType.BASIC);
            case (2) -> displayAvailableRooms(RoomType.COMFORT);
            case (3) -> displayAvailableRooms(RoomType.DUO);
            default -> {
                System.out.println("Przepraszamy, wystąpił błąd.\n *Restart systemu*");
                displayLoading(100);
            }
        }
    }
    public void displayAvailableRooms(RoomType type){
        this.hotel.initTransaction();

        ArrayList<Room> availableRooms = this.hotel.getRooms();
        availableRooms.removeIf(room -> room.roomType != type && room.key.isFree());
        System.out.println("Dostępne pokoje typu " + type.toString());
        for (Room room : availableRooms) {
            System.out.println(" Pokój nr " + room.key.getId());
        }
        System.out.println("Wpisz numer wybranego pokoju :");
        Scanner scanner = new Scanner(System.in);
        int userChoice = Integer.parseInt(scanner.nextLine());
        this.hotel.current_transaction.setRoomId(userChoice);
        displayLoading(40);
        displayAvailableServices(userChoice);


    }

    public void displayAvailableServices(int roomId){
        Room user_room = hotel.getRoomById(roomId);
        int i;
        boolean[] selectedServices = new boolean[user_room.available_services.size()];
        int userChoice = -1;
        System.out.println("Dostępne serwisy w tym pokoju:");

        while (userChoice != 0) {
            i = 0;
            System.out.println("0. Przejdź dalej");
            for (Service service : user_room.available_services) {
                String activeWord = (selectedServices[i]) ? "AKTYWNY" : "NIEAKTYWNY";
                System.out.println((i + 1) + ". ["+activeWord+"] " + service.getInfo() + " ");
                i++;
            }
            userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice != 0){
                selectedServices[userChoice - 1] = !selectedServices[userChoice - 1];
            }
        }

        for (int j = 0; j < selectedServices.length; j++) {
            if (selectedServices[j]) {
                user_room.activateService(j);
            }
        }
        displayLoading(60);
        displayPaymentForm();
    }

    public void displayPaymentForm(){
        Room user_room = this.hotel.getRoomById(this.hotel.current_transaction.getRoomId());
        float servicesCost = 0.f;
        for (int serviceId: user_room.active_services){
            servicesCost += user_room.available_services.get(serviceId).getPrice();
        }
        System.out.println("------Rachunek-----");
        System.out.println(user_room.price + " - koszt pokoju\n" + servicesCost + " - koszt serwisów\n" + (user_room.price + servicesCost) + " - suma" );
        System.out.println("Proszę zapłacic korzystając z terminala.");
        System.out.println("1. Zapłać ");
        System.out.println("2. Anuluj transakcje ");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice) {
            case (1) -> {
                displayLoading(100);
                displaySummary();
            }
            case (2) -> {
                this.hotel.clearCurrentTransaction();
                displayStart();
            }
            default -> {
                System.out.println("Przepraszamy, wystąpił błąd.\n *Restart systemu*");
                displayLoading(100);
            }
        }
    }

    public void displaySummary(){
        System.out.println("Transakcja zakończona pomyślnie!\n Odbierz karte pokoju z podajnika");
        System.out.println("Zyczymy miłego pobytu.");
        hotel.checkin();
        displayStart();
    }

    public void displayClientOptions(int roomId){
        Room userRoom = this.hotel.getRoomById(roomId);
        Duration timeLeft = Duration.between(userRoom.key.getClient().from_date,userRoom.key.getClient().to_date);
        System.out.println("---------------------------");
        System.out.println("Witaj\nPozostało ci " + timeLeft.toDays() + " dni " + (timeLeft.toHours() % 24) + " godzin oraz " + (timeLeft.toMinutes() % 60) + " minut");
        System.out.println("Dostępne opcje: ");
        System.out.println("1. Dodaj serwis do pokoju");
        System.out.println("2. Zgłoś problem");
        System.out.println("3. Zakończ pobyt");
        System.out.print("---| ");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice){
            case (1) -> addServicesForm(roomId);
            case (2) -> reportForm(roomId);
            case (3) -> {
                displayLoading(30);
                System.out.println("Dziekujemy za pobyt i zapraszamy ponownie");
                displayLoading(30);
                this.hotel.checkout(roomId);
                displayStart();
            }
            default -> {
                System.out.println("Przepraszamy, wystąpił błąd.\n *Restart systemu*");
                displayLoading(100);
            }
        }

    }

    public void reportForm(int roomId){
        System.out.println("Opisz problem dotyczący pokoju nr. " + roomId);
        System.out.println("Tytuł problemu: ");
        String reportName = scanner.nextLine();
        System.out.println("Opis problemu: ");
        String reportDescription = scanner.nextLine();
        Room userRoom = hotel.getRoomById(roomId);
        userRoom.reportProblem(reportName,reportDescription);
        System.out.println("Dziękujemy za zgłoszenie");
        displayClientOptions(roomId);
    }

    public void addServicesForm(int roomId){
        Room userRoom = hotel.getRoomById(roomId);
        System.out.println("Wybierz serwis który chcesz aktywować:");
        int i = 0;
        System.out.println("0. Anuluj");
        for (; i < userRoom.available_services.size(); i++) {
            if(!userRoom.active_services.contains(i)){
                System.out.println( (i+1)+ ". " + userRoom.available_services.get(i).getInfo());
            }
        }
        int selectedService = Integer.parseInt(scanner.nextLine());
        if (selectedService == 0){
            displayClientOptions(roomId);
        }else{
            System.out.println("Do zapłaty - " + userRoom.available_services.get(selectedService-1).getPrice() + " zł");
            System.out.println("Zapłać korzystając z terminalu");
            System.out.println("1. Zapłać\n2. Anuluj");
            int userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice){
                case (1) -> {
                    displayLoading(40);
                    userRoom.activateService(selectedService-1);
                    System.out.println("Serwis pomyślnie dodany!");
                    displayLoading(80);
                    displayClientOptions(roomId);
                }
                case (2) -> {
                    System.out.println("Anulowanie transakcji");
                    displayClientOptions(roomId);
                }
                default -> {
                    System.out.println("Przepraszamy, wystąpił błąd.\n *Restart systemu*");
                    displayLoading(100);
                }
            }

        }

    }
    public void displayLoading(int period) {
        for (int i = 0; i < 30; i++) {
            System.out.print(".");
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
