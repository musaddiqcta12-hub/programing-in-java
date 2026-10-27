import java.util.*;

class Payment {
    void makePayment(double amount) {
        System.out.println("Amount = " + amount);
    }

    void makePayment(double amount, double paymentAmount, String transactionId) {
        System.out.println("Credit Card Payment");
        System.out.println("Amount = " + amount);
        System.out.println("Payment Amount = " + paymentAmount);
        System.out.println("Transaction ID = " + transactionId);
    }
}

class CreditCardPayment extends Payment {
    @Override
    void makePayment(double amount, double paymentAmount, String transactionId) {
        System.out.println("Credit Card Payment");
        System.out.println("Amount = " + amount);
        System.out.println("Payment Amount = " + paymentAmount);
        System.out.println("Transaction ID = " + transactionId);
    }
}

class UPIPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("UPI Payment");
        System.out.println("Amount = " + amount);
    }
}

class NetBankingPayment extends Payment {
    @Override
    void makePayment(double amount) {
        System.out.println("Net Banking Payment");
        System.out.println("Amount = " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double amount = sc.nextDouble();
        double paymentAmount = sc.nextDouble();
        String transactionId = sc.next();
        double upiAmount = sc.nextDouble();
        double netAmount = sc.nextDouble();

        Payment p = new CreditCardPayment();
        p.makePayment(amount, paymentAmount, transactionId);

        p = new UPIPayment();
        p.makePayment(upiAmount);

        p = new NetBankingPayment();
        p.makePayment(netAmount);

        sc.close();
    }
}
