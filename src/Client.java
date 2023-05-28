import java.time.LocalDate;

public class Client {
    private int id;
    private int roomId;
    private LocalDate from_date;
    private LocalDate to_date;
    private Transaction transaction;

    public Client(int id, int roomId, Transaction transaction, long days) {
        this.id = id;
        this.roomId = roomId;
        this.transaction = transaction;
        this.from_date = LocalDate.now();
        this.to_date = LocalDate.now().plusDays(days);
    }
}
