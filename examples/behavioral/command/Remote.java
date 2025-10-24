package examples.behavioral.command;
class Remote {
    Command command;
 
    void pressButton() {
        command.execute();
    }
}
