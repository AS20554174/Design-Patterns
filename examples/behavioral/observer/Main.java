package examples.behavioral.observer;
public class Main {
    public static void main(String[] args) {
 
        InstagramAccount account = new InstagramAccount();
        account.follow("Asha", "Sruthi"); // Followers added
 
        account.postPhoto("Sunset Photo"); // Notification sent
    }
}