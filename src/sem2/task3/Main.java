package sem2.task3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Workable backend = new Backend("Jonn");
        Workable frotend = new Frontend("Mike");
        Workable fullstack = new Fullstack("Nik");

        backend.doWork();
        frotend.doWork();
        fullstack.doWork();

    }
}
