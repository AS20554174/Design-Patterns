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