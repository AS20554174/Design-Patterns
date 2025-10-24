package examples.creational.builder;

public class Main {
    public static void main(String[] args) {
        User user = new UserBuilder()
                        .setUsername("Asha")
                        .setPassword("12345")
                        .build();
 
        System.out.println(user);
    }
}