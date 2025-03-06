package sem2;

public class Server  {
    public static boolean isConnect;
    Listenaranable action;

    public void buttonAction(String str) {

    }

    public Server(Listenaranable action) {
        this.action = action;
    }
    void CallmetodIF(){
        action.buttonAction("Hello. Ok!!!");
    }
}

