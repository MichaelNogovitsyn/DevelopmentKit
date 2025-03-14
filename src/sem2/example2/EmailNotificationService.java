package sem2.example2;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

