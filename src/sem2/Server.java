package sem2;

public class Server {
    public static boolean isConnect;
    public static boolean isClose;
    Listenaranable interface1;
    Listenaranable interface2;
    public void buttonAction(String str) {
    }

    public Server(Listenaranable action,Listenaranable action2) {
        this.interface1 = action;
        this.interface2 = action2;
    }

    void callmetodIF() {
        interface1.buttonAction("Button pressed from IF1");
    }

    void callmetodIF2() {
        interface2.buttonAction("Button pressed from IF2");
    }
}



