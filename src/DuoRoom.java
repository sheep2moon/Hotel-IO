public class DuoRoom extends Room {
    public DuoRoom(int number) {
        super(number);
        this.roomType = RoomType.DUO;
        price = 220.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
        available_services.add(new Service("VOD", "Dostęp do pakietu VOD z najnowszymi filmami", 18.f));
        available_services.add(new Service("Konsola do gier", "Dostęp do konsoli do gier z pakietem gier", 24.f));
    }
}
