public class Singleton {
 
    private static Singleton instance;
 
    private Singleton() {
        System.out.println("Singleton object created"); // kept from your code
    }
 
    // create a public method that gives the same object every time
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
