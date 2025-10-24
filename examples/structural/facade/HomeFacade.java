package examples.structural.facade;

class HomeFacade {
 
    Light light = new Light();
    Fan fan = new Fan();
 
    void startHome() {
        light.turnOn();
        fan.turnOn();
        System.out.println("Home started!");
    }
}