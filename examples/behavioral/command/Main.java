package examples.behavioral.command;
public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
 
        Command startFan = new StartFanCommand(fan);
 
        Remote remote = new Remote();
        remote.command = startFan;
 
        remote.pressButton();
    }
}
