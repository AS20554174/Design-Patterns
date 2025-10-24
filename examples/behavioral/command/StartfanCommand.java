package examples.behavioral.command;
class StartFanCommand implements Command {
    Fan fan;
 
    StartFanCommand(Fan fan) {
        this.fan = fan;
    }
 
    public void execute() {
        fan.start();
    }
}