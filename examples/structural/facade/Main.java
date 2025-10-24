package examples.structural.facade;
public class Main {
    public static void main(String[] args) {
        HomeFacade home = new HomeFacade();
        home.startHome(); // single call to start everything
    }
}
