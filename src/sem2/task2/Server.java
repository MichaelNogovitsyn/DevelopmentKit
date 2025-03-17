package sem2.task2;

public class Server implements Clickable {
    public static boolean isConnect;
    public static boolean isClose;
    Listenaranable interface1;

    public Server(Listenaranable interface1) {
        this.interface1 = interface1;
    }

    @Override
    public void sendMsg(String str) {
        interface1.interfaceMetod("Msg send");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected");
    }

    @Override
    public void login(String login, String password) {
        System.out.println("Login success");
    }
}



