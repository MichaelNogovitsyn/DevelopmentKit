package sem2.example2;

public class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending push notification to " + recipient + ": " + message);
    }
}