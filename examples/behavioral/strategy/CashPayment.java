package examples.behavioral.strategy;
class CashPayment implements PaymentStrategy {
 
    @Override
    public void pay() {
        System.out.println("Paid using Cash");
    }
}