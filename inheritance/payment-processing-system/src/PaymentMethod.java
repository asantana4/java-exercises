import java.text.NumberFormat;

public abstract class PaymentMethod {

    protected String accountHolder;
    protected double balance;
    protected final static NumberFormat MONEY_FORMATTER = NumberFormat.getCurrencyInstance();

    public PaymentMethod(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public final boolean processPayment(double amount) {
        boolean paymentCanGoThrough = false;
        if (validatePayment(amount) && hasSufficientBalance(amount)) {
            paymentCanGoThrough = true;
            deductBalance(amount);
            double transactionFee = calculateFee(amount);
            balance += transactionFee;
            logTransaction(amount, transactionFee);
        }
        return paymentCanGoThrough;
    }

    protected boolean validatePayment(double amount) {
        return (accountHolder != null && !accountHolder.isBlank()) && amount > 0;
    };
    protected abstract double calculateFee(double amount);
    protected abstract boolean hasSufficientBalance(double amount);
    protected abstract void deductBalance(double amount);
    protected final void logTransaction(double amount, double fee) {
        System.out.printf("%s - %s - %s fee%n", this.getClass().getSimpleName(), MONEY_FORMATTER.format(amount),
                MONEY_FORMATTER.format(fee));
    }

    @Override
    public String toString() {
        return """
                %s
                Balance: %s
                """.formatted(accountHolder, MONEY_FORMATTER.format(balance));
    }
}


class CreditCardPayment extends PaymentMethod {

    private double creditLimit;

    public CreditCardPayment(String accountHolder, double balance, double creditLimit) {
        super(accountHolder, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.03;
    }

    @Override
    protected boolean hasSufficientBalance(double amount) {
        return balance + amount <= creditLimit;
    }

    @Override
    protected void deductBalance(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return super.toString() + "Credit limit: %s%n".formatted(MONEY_FORMATTER.format(creditLimit));
    }
}

class DebitCardPayment extends PaymentMethod {


    public DebitCardPayment(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    protected double calculateFee(double amount) {
        return amount * 0.01;
    }

    @Override
    protected boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    @Override
    protected void deductBalance(double amount) {
        balance -= amount;
    }
}


class PayPalPayment extends PaymentMethod {

    private boolean verifiedAccount;
    public PayPalPayment(String accountHolder, double balance, boolean verifiedAccount) {
        super(accountHolder, balance);
        this.verifiedAccount = verifiedAccount;
    }

    @Override
    protected boolean validatePayment(double amount) {
        return super.validatePayment(amount) && verifiedAccount;
    }

    @Override
    protected double calculateFee(double amount) {
        return amount >= 1000.0 ? amount * 0.02 : amount >= 500.0 ? amount * 0.03 : amount * 0.04;
    }

    @Override
    protected boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    @Override
    protected void deductBalance(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return super.toString() + "Verified account: %b%n".formatted(verifiedAccount);
    }
}