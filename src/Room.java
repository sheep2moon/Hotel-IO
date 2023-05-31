import java.util.ArrayList;

public abstract class Room {
    Key key;
    float price;
    RoomType roomType;

    boolean isReady;
    ArrayList<Service> available_services;
    ArrayList<Integer> active_services;
    ArrayList<Report> reports;

    public Room(int number){
        this.available_services = new ArrayList<>();
        this.active_services = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.isReady = true;
        key = new Key(number);
    }

    public void activateService(int serviceId){
        active_services.add(serviceId);
    }
    public void reportProblem(String title, String description){
        Report newReport = new Report(key.getId(),title,description );
        reports.add(newReport);
    }
}
