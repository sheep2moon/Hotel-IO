import java.util.ArrayList;

public class Room {
    Key key;
    float price;
    ArrayList<Service> available_services;
    ArrayList<Integer> active_services;
    ArrayList<Report> reports;

    public void activateService(int serviceId){
        active_services.add(serviceId);
    }
    public void reportProblem(String title, String description){
        Report newReport = new Report(key.id,title,description );
        reports.add(newReport);
        System.out.println("Dziękujemy za zgłoszenie problemu");
    }
}
