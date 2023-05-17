public class Report {
    private static int nextId = 1;
    private int id;
    private int roomId;
    private String name;
    private String description;

    public Report( int roomId, String name, String description) {
        this.id = nextId;
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        nextId += 1;
    }
}
