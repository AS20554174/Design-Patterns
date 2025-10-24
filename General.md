# Design Patterns
Design patterns are reusable solutions to common problems that appear during software design and development.
They are often used as ready made templates and best practices that software developers use to write better, cleaner and maintainable code.
## Why Do We Use Them?
- To avoid rewriting the same logic again and again.
- Improve code readability and team understanding.
- Make code flexible easy to change or extend later.
- Solve recurring design problems in a standard way.
## Types of Design Patterns
The Gang of Four(GOF) authors Richard Helm,Ralph Johnson,Erich Gamma and John Vlissides introduced 23 patterns divided into 3 main categories:
1.Creational Patterns
2.Structural Patterns
3.Behavioral patterns
## 1.Creational patterns:
Creational Patterns are classified into 3 types:
1.Singleton pattern
2.Factory pattern
3.Builder pattern
### 1.Singleton pattern
- It ensures only one object of a class is created throughout the program.
- It avoids creating too many objects.
- To use the same object everywhere.
- We use Singleton Pattern when you need only one instance like database connection,Logger and configuration class.


### Example (Java)
```java
class Singleton {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Singleton object created");
    }
    // create a public method that gives the same object everytime
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class Main{
public static void main(String[] args) {
    Singleton obj1 = Singleton.getInstance();
    Singleton obj2 = Singleton.getInstance();
    System.out.println(obj1 == obj2);
}
}
```

**Output:**
```
Singleton object created!
true 
```
### Explanation:
- Singleton class has a private constructor- preventscreating multiple objects.
- instance is a static variable,stores the single instance.
- getInstance() checks if an instance exists,if not creates it.
- both obj1 and obj2 point to the same object,so obj1=obj2 is true.

### 2.Factory pattern:
- Factory pattern is a Creational pattern used when we want to create objects without exposing the creation logic to the user.
- User only know the interface or abstract type, not the exact class being instantiated.
- We use this pattern when object creation is complex.
- When we want flexibility to add new types without changing existing code.


### Example (Java)
```java
interface Drink{
    void serve();
}
//concrete classes
class Tea implements Drink{
    void serve() {
        System.out.println("Serving hot tea");
    }
}
class Coffee implements Drink{
    void serve() {
        System.out.println("Serving hot coffee");
    }
}
//factory class to generate object based on input
class DrinkFactory{
    public static Drink getDrink(String type) {
        if(type.equalsIgnoreCase("tea"))
        {
            return new Tea(); //create tea object
        } else if(type.eqaulsIgnoreCase("coffee"))
        {
            return new Coffee(); //create coffee object
        } else {
            return null;
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Drink d1 = DrinkFactory.getDrink("tea"); //Ask for tea
        Drink d2 = DrinkFactory.getDrink("coffee"); //Ask for coffee
        d1.serve(); //prints serving hot tea
        d2.serve(); //prints serving hot coffee
    }
}
```

**Output:**
```
Serving hot tea
Serving hot coffee
```
### Explanation:
- Drink is an interface define serve() for all drinks.
- Tea and Coffee are concrete classes implementing Drink.
- DrinkFactory decides which oject to create based on input.
- The main program calls the factory, it doesnt create tea or coffee directly.
### 3.Builder pattern:
- Builds complex objects step by step instead of calling a huge constructor.
- It is used when you have many parameters to set.
- It makes object creation clean,readable and flexible.
- It avoids using long constructors with too many parameters.

### Example
### User.java(Product class)
```java

public class User{
    private String username;
    private String password;
    Public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String toString() {
        return "User[Username = " +username+ ",Password = " +password+ "]";
    }
}
```

### UserBuilder.java
```java

public class UserBuilder{
    private String username; //temporary variables to store data
    private String password;
    public UserBuilder setUsername(String username) { //Method to set username
    this.username = username; //store username in builder
    return this; //return builder for method chaining
    }
    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    //method to build the final User object
    public User build() {
        return new User(username,password);
    }
}
public class Main{
    public static void main(String[] args) {
    //Using builder pattern to create user object
    User user = new UserBuilder().setUsername("Asha").setPassword("1234").build();
    //printing user details
    System.out.println(user);
    }
}
```

**Output:**
```
User [Username = Asha, Password = 1234]
```
### Explanation:
- The Builder pattern program uses the UserBuilder class to create User objects step by step.
- The builder stores temporary values like username and password.
- Methods such as setUsername() and setPassword() set these values and return builder to allow method chaining.
- The build() method then creates the final User object using the stored values.
- This pattern helps avoid long constructors, makes object creation clean and readable and ensures the object is fully initialised before use.
## 2.Structural Patterns:
- Structural Patterns deals with how classes and objects are combined to form large structures.
- They focus on the structure or relationship between objects.
- To allow different classes to work together even if they are not directly compatible.
- To reuse existing code instead of rewriting it.
There are 7 types of Structural Patterns:
1.Adapter
2.Bridge
3.Composite
4.Decorator
5.Facade
6.Flyweight
7.Proxy
### 1.Adapter Pattern:
- It is a structural pattern that allows two incompatible interfaces to work together.
- It acts as a bridge between the old class and the new class by converting one interface into another that the client expects.


### Example
```java
class OldMusicPlayer{
    void playOldSong() {
        System.out.println("Playing song from old cassette player");
    }
}
//Adapter
class MusicAdapter{
    OldMusicPlayer oldPlayer = new OldMusicPlayer();
    void playModernSong() {
        oldPlayer.playOldSong(); //adapts old method to new
    }
}
public class Main{
    public static void main(String[] args) {
        MusicAdapter adapter = new MusicAdapter();
        adapter.playModernSong();
    }
}
```

**Output:**
```
Playing song from old cassettee player
```
### Explanation
- Adapter Pattern works as bridge between two incompatible systems, it lets old code work with new code without changing the old code.
- OldMusicPlayer class is a syatem that can only play songs from a cassette player.
- MusicAdapter class is a adapter that connects the new systen(modern music player) with the old system.Inside it wecan create an object of OldMusicPlayer and calls its old method(playOldSong()).
- In main class we dont directly use the old system.Instead we use the MusicAdapter to play modern sings,which internally calls the old players method.

### 2.Facade Pattern:
- It is a structural design pattern that provides Simple interface to a complex subsystem.
- It hides the complexity of multiple classes and allows the client to interact with the system using one method.
- To hide internal implementation details facade pattern is used.


### Example:
```java
//Subsystem classes
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
}
 
class Fan {
    void turnOn() {
        System.out.println("Fan is ON");
    }
}
 
// Facade class
class HomeFacade {
    Light light = new Light();
    Fan fan = new Fan();
 
    void startHome() {
        light.turnOn();
        fan.turnOn();
        System.out.println("Home started!");
    }
}
public class Main {
    public static void main(String[] args) {
        HomeFacade home = new HomeFacade();
        home.startHome(); // Single call to start everything
    }
}
```

**Output:**
```
Light is ON
Fan is ON
Home started!
```
### Explanation
- Light and Fan are subsystem classes.
- HomeFacade simplifies interaction — the client only calls startHome()
- The client does not need to call each subsystem individually.
- Facade pattern improves readability and reduces complexity.
## 3.Behavioral Patterns:
- Behavioral Patterne are concerned with how objects communicate and interact with each other.s
- They define ways of managing algorithims, responsibilities and communication betureen objects.
 - Makes the communication between objects clear & flexible
 - Improves code maintainability and readability.
 Behavioral patterns are classified into 3 types:
 - 1.Observer pattern
 - 2.Strategy pattern
 - 3.Command pattern
 ### 1.Observer pattern:
 - Observer pattern allows an object to notify multiple other objects automatically when its state changes.


 ### Example
 ```java
 class InstagramAccount {
    String follower1, follower2;
 
    // Method to follow users
    void follow(String f1, String f2) {
        follower1 = f1;
        follower2 = f2;
    }
 
    // Method to post a photo
    void postPhoto(String photo) {
        System.out.println("Posted: " + photo);
        System.out.println("Notified: " + follower1);
        System.out.println("Notified: " + follower2);
    }
}
 
public class Main {
    public static void main(String[] args) {
        InstagramAccount account = new InstagramAccount();
        account.follow("Asha", "Sruthi");
        account.postPhoto("Sunset Photo");
    }
}
```

**Output:**
```
Posted: Sunset Photo
Notified: Asha
Notified: Sruthi
```

## Explanation:
- InstagramAccount class: Stores followers and lets you post photos.
- follow() method: Sets the followers’ names.
- postPhoto() method: Prints the photo posted and notifies all followers.
- Main class: Creates an account, adds followers, and posts a photo.
- It basically simulates posting a photo and notifying followers.
### 2.Strategy pattern:
- Strategy Pattern allows an object to change it's behavior dynamically at runtime based on the situation. 
- It helps in defining multiple ways to perform the same action, and we can choose the required strategy wherever needed.
 


 ### Example:
 ```java
 interface PaymentStrategy {
    void pay();
}
 
// Step 2: Implement card payment
class CardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid using Card");
    }
}
 
// Step 3: Implement cash payment
class CashPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid using Cash");
    }
}
public class Main {
    public static void main(String[] args) {
        PaymentStrategy payment = new CardPayment();
        payment.pay();  // Output: Paid using Card
 
        payment = new CashPayment();
        payment.pay();  // Output: Paid using Cash
    }
}
```

**Output:**
```
Paid using Card
Paid using Cash
```

### Explanation:
- PaymentStrategy → Interface defining pay() method.
- CardPayment and CashPayment → Different ways to pay (strategies).
- Main class → Uses different strategies at runtime.

### 3.Command pattern:
- It is used to encapsulate a request as an object, allowing us to store, queue, or undo commands easily.
- It separates the request from the object that executes it.
- Ex: when you press ON or OFF button, you are not directly touching the TV,each button represents a command that tells the TV what to do.


### Example:
```java
interface Command {
    void execute();
}
 
// Step 2: Receiver class (Fan)
class Fan {
    void start() {
        System.out.println("Fan Started!");
    }
}
 
// Step 3: Concrete Command class
class StartFanCommand implements Command {
    Fan fan;
 
    StartFanCommand(Fan fan) {
        this.fan = fan;
    }
 
    public void execute() {
        fan.start();
    }
}
// Step 4: Invoker class (Remote)
class Remote {
    Command command;
 
    void pressButton() {
        command.execute();
    }
}
public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();                        
        Command startFan = new StartFanCommand(fan);
        Remote remote = new Remote();                
        remote.command = startFan;  
        remote.pressButton();        // Executes command
    }
}
```

**Output:**
```
Fan Started!
```

### Explanation:
- Command interface → defines execute()
- Fan → receiver (performs real action)
- StartFanCommand → concrete command (calls fan.start())
- Remote → invokes command (pressButton())
- Main → connects all parts and runs
---
# Anti-Patterns:
- An anti-pattern is a bad solution to a problem, it may look good at first, but later it creates more problems look in your project.
- Misusing design patterns without understanding.
- Trying to use a pattern everywhere (force-fitting)
- Writing quick fixes instead of proper design.
- copy-parting code without thinking..
- Anti patterns are of 3 types:
- 1. Design Anti-Patterns
- 2. Coding Anti-Patterns
- 3. Project Management Anti-Patterns.
## 1.Design Anti-Patterns:
- These happen when the software design or structure is poorly done.
- These are classified into 3 types:
- 1. God object
- 2. Spaghetti Code
- 3. Golden hammer
### 1.God object:
- A God object is a claes that tries to do everything.
- it has too many responsibilities, making the program hard to understand, test and maintain.
- This violates the single Responsibility principle in object oriented Programming.


### Example:
```java
// God Object - doing too many things  
class ApplicationManager {  
    void manageUser() {  
        System.out.println("Managing user data...");  
    }  
  
    void processPayment() {  
        System.out.println("Processing payment...");  
    }  
  
    void generateReport() {  
        System.out.println("Generating report...");  
    }  
}  
  
public class Main {  
    public static void main(String[] args) {  
        ApplicationManager app = new ApplicationManager();  
  
        app.manageUser();  
        app.processPayment();  
        app.generateReport();  
    }  
}
```
**Output:**
 ```
Managing user data...
Processing payment...
Generating report...
```
### 2.Spaghetti Code:
- Spaghetti code means code that is tangled and messy-Just like a bowl of spaghetti.
- There is no clear structure or flow, making it very hard to read, understand or modify. It usually happens when a program has too many if else statements or repeated logic without proper structure..

### Example:
```java
public class Main {
    public static void main(String[] args) {
        int choice = 2;
 
        if (choice == 1) {
            System.out.println("Add Item");
        } else if (choice == 2) {
            System.out.println("Delete Item");
        } else if (choice == 3) {
            System.out.println("Update Item");
        } else if (choice == 4) {
            System.out.println("View Item");
        } else {
            System.out.println("Invalid choice");
        }
    }
}
```

**Output:**
```
Delete Item
```
### 3.Golden Hammer:
- It means using one familiar solution for every problem-even when its not the best fit.
- Its like having only a hammer and thinking every problem is a nail.
- In programming, it happens when we we use the same logic or technology everywhere instead of choosing whats suitable.


### Example:
```java
public class Calculator {
 
    void calculate(String operation, int a, int b) {
        if (operation.equals("add")) {
            System.out.println(a + b);
        } else if (operation.equals("subtract")) {
            System.out.println(a - b);
        } else if (operation.equals("multiply")) {
            System.out.println(a * b);
        } else if (operation.equals("divide")) {
            System.out.println(a / b);
        } else {
            System.out.println("Operation not supported");
        }
    }
 
    public static void main(String[] args) {
        Calculator calc = new Calculator();
 
        calc.calculate("add", 10, 5);       // prints 15
        calc.calculate("divide", 20, 4);    // prints 5
        calc.calculate("mod", 10, 3);       // prints Operation not supported
    }
}
```
**Output:**
```
15
5
Operation not supported
```
## 2.Coding Anti-Pattern:
- Coding antipatterns happen due to bad programming or poor implementation.They make the code hard to read,maintain or reuse.
- It is classified into 3 types:
- 1.Copy-Paste programming
- 2.Hard Coding
- 3.magic Numbers

### 1.Copy-Paste Programming:
-Copying code from one place to another instead of writing reusable methods.
- Leads to duplication and makesmaintenance hard.


### Example:
```java
// Copy-Paste Programming - duplicating code instead of reusing
public class CopyPasteExample {
    public static void main(String[] args) {
        // First calculation
        int a = 10, b = 5;
        System.out.println("Sum: " + (a + b));
 
        // Copied code for another calculation
        int x = 20, y = 15;
        System.out.println("Sum: " + (x + y));
    }
}
```

**Output:**
```
Sum: 15
Sum: 35
```
### 2.Hard Coding:
- Storing
 
 
 