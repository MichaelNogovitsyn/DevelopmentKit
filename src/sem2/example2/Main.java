package sem2.example2;

public class Main {
    public static void main(String[] args) {
        // Используем EmailNotificationService
        NotificationService emailService = new EmailNotificationService();
        TaskManager taskManager = new TaskManager(emailService);
        taskManager.createTask("Finish report", "user@example.com");

        // Используем SmsNotificationService
        NotificationService smsService = new SmsNotificationService();
        taskManager = new TaskManager(smsService);
        taskManager.createTask("Call client", "+123456789");

        // Используем PushNotificationService
        NotificationService pushService = new PushNotificationService();
        taskManager = new TaskManager(pushService);
        taskManager.createTask("Buy groceries", "user_device_id");
    }
}