package examples.creational.factory;

public class Main {
    public static void main(String[] args) {
        Drink d1 = DrinkFactory.getDrink("tea");     // Ask for tea
        Drink d2 = DrinkFactory.getDrink("coffee");  // Ask for coffee
 
        d1.serve(); // prints Serving hot tea
        d2.serve(); // prints Serving hot coffee
    }
}
    
