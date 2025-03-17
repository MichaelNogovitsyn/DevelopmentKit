package sem2.example2;

public class TaskManager {
    private NotificationService notificationService;

    // Конструктор для установки сервиса уведомлений
    public TaskManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Метод для создания задачи и отправки уведомления
    public void createTask(String taskName, String recipient) {
        System.out.println("Task created: " + taskName);
        notificationService.sendNotification("New task: " + taskName, recipient);
    }
}