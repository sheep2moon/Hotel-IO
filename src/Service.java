public class Service {
    private static int next_id = 1;
    private int id;
    private String name;
    private String description;
    private float price;

    public Service( String name, String description, float price) {
        this.id = next_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.next_id += 1;
    }
}
