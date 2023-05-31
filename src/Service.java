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
        next_id += 1;
    }

    public float getPrice(){
        return  price;
    }
    public String getInfo() {
        return "" + this.name + " - " + this.description + " cena: " + Float.toString(this.price) + " zł.";
    }
}
