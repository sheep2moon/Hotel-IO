public class ComfortRoom extends Room {
    public ComfortRoom(int number) {
        super(number);
        price = 160.f;
        available_services.add(new Service("Internet", "Dostęp do szybkiego internetu światłowodowego", 12.f));
        available_services.add(new Service("VOD", "Dostęp do pakietu VOD z najnowszymi filmami", 18.f));
    }
}
