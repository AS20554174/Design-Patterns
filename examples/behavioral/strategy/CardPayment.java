package examples.behavioral.strategy;
class CardPayment implements PaymentStrategy {
 
    @Override
    public void pay() {
        System.out.println("Paid using Card");
    }
}
