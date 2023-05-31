public class BasicRoom extends Room {
    public BasicRoom(int number) {
        super(number);
        this.roomType = RoomType.BASIC;
        price = 100.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
    }
}
