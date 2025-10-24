package examples.behavioral.observer;
class InstagramAccount {
 
    String follower1, follower2;
 
    // Method to follow users
    void follow(String f1, String f2) {
        follower1 = f1;
        follower2 = f2;
    }
 
    // Method to post a photo (Notify followers)
    void postPhoto(String photo) {
        System.out.println("Posted: " + photo);
        System.out.println("Notified: " + follower1);
        System.out.println("Notified: " + follower2);
    }
}