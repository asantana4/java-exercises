public class Main {


    public static void main(String[] args) {
        double paymentAmount = 1000.0;
        double balance = 2000;
        PaymentMethod[] paymentMethodsArray = {
                new CreditCardPayment("Jose C.", balance, 3500.0),
                new DebitCardPayment("Mateo R.", balance),
                new PayPalPayment("Ramon A.", balance, true)
        };
        for (var paymentMethod : paymentMethodsArray) {
            System.out.println(paymentMethod);
            paymentMethod.processPayment(paymentAmount);
            System.out.println(paymentMethod);
            System.out.println("-".repeat(30));
        }



    }
}
