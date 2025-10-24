package examples.behavioral.strategy;
public class Main {
    public static void main(String[] args) {
 
        PaymentStrategy payment = new CardPayment();
        payment.pay(); // Output: Paid using Card
 
        payment = new CashPayment();
        payment.pay(); // Output: Paid using Cash
    }
}