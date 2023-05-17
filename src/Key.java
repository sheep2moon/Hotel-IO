public class Key {
    private int id;
    private Client currentClient;

    public Key(int id){
        this.id = id;
    }

    public boolean isFree(){
        return currentClient == null;
    }
    public void attachClient(Client client){
        currentClient = client;
    }
    public void detachClient(){
        currentClient = null;
    }

    public int getId() {
        return id;
    }
}
