package sem2.task3;

public class Fullstack extends  Developer implements Workable{
    public Fullstack(String name) {
        super(name);
    }

    @Override
    public void doWork() {
        System.out.println("Работаю с фронтэндом и бэкэндом");
    }
}
