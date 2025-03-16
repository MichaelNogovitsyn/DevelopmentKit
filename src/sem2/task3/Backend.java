package sem2.task3;

public class Backend extends Developer implements Workable{
    public Backend(String name) {
        super(name);
    }

    @Override
    public void doWork() {
        System.out.println("Работаю с бэкендом");
    }
}
