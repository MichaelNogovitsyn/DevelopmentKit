package sem2.example2;

public class SmsNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

