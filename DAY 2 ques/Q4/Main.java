package Q4;

import javax.annotation.processing.SupportedOptions;

interface PaymentStrategy{
    boolean processPayment(double amount);
}

class CreditCardStrategy implements PaymentStrategy{

    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing amount: " + amount);
        return true;
    }
}

class CryptoStrategy implements PaymentStrategy{

    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing amount: " + amount);
        return true;
    }
}

class TransactionProcessor{
    private PaymentStrategy strategy;

    public TransactionProcessor(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void executeTransaction(double amount) {

        boolean result = strategy.processPayment(amount);

        if(result) {
            System.out.println("Transaction Successful");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        TransactionProcessor processor =
                new TransactionProcessor(
                        new CreditCardStrategy());

        processor.executeTransaction(5000);

        System.out.println();

        processor.setPaymentStrategy(
                new CryptoStrategy());

        processor.executeTransaction(10000);
    }
}