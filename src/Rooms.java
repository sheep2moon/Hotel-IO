import java.util.ArrayList;

public abstract class Room {
    Key key;
    float price;
    ArrayList<Service> available_services;
    ArrayList<Integer> active_services;
    ArrayList<Report> reports;

    public Room(int number){
        key = new Key(number);
    }

    public void activateService(int serviceId){
        active_services.add(serviceId);
    }
    public void reportProblem(String title, String description){
        Report newReport = new Report(key.getId(),title,description );
        reports.add(newReport);
        System.out.println("Dziękujemy za zgłoszenie problemu");
    }
}

public class BasicRoom extends Room{
    public BasicRoom(int number) {
        super(number);
        price = 100.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
    }
}
public class ComfortRoom extends Room{
    public ComfortRoom(int number) {
        super(number);
        price = 160.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
        available_services.add(new Service("VOD", "Dostęp do pakietu VOD z najnowszymi filmami", 18.f));
    }
}
public class DuoRoom extends Room{
    public DuoRoom(int number) {
        super(number);
        price = 220.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
        available_services.add(new Service("VOD", "Dostęp do pakietu VOD z najnowszymi filmami", 18.f));
        available_services.add(new Service("Konsola do gier", "Dostęp do konsoli do gier z pakietem gier", 24.f));
    }
}
