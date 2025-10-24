package examples.creational.factory;
interface Drink {
    void serve();
}
 
// concrete classes
class Tea implements Drink {
    public void serve() {
        System.out.println("Serving hot tea");
    }
}
 
class Coffee implements Drink {
    public void serve() {
        System.out.println("Serving hot coffee");
    }
}
 
// factory class
class DrinkFactory {
    public static Drink getDrink(String type) {
        if(type.equalsIgnoreCase("tea")) {
            return new Tea(); // create tea object
        } else if(type.equalsIgnoreCase("coffee")) {
            return new Coffee(); // create coffee object
        } else {
            return null;
        }
    }
}