package examples.creational.builder;
public class User {
 
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
 
    @Override
    public String toString() {
        return "User [Username = " + username + ", Password = " + password + "]";
    }
}

