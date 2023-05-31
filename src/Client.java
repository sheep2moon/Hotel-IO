import java.time.LocalDate;
import java.time.LocalDateTime;

public class Client {
    private static int nextId = 1;
    private int id;
    private int roomId;
    public LocalDateTime from_date;
    public LocalDateTime to_date;
    private Transaction transaction;

    public Client( int roomId, Transaction transaction, long days) {
        this.id = nextId;
        this.roomId = roomId;
        this.transaction = transaction;
        this.from_date = LocalDateTime.now();
        this.to_date = LocalDateTime.now().plusDays(days);
        nextId++;
    }
}
