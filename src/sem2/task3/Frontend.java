package sem2.task3;

public class Frontend extends Developer implements Workable{
    public Frontend(String name) {
        super(name);
    }

    @Override
    public void doWork() {
        System.out.println("работаю с фронендом");
    }
}
