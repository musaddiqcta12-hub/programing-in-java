class BankAccount {
    int balance = 10000;

    synchronized void deposit(String user, int amount) {
        balance += amount;
        System.out.println(user + " deposited: " + amount + " | Balance: " + balance);
    }

    synchronized void withdraw(String user, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " withdrew: " + amount + " | Balance: " + balance);
        } else {
            System.out.println(user + " insufficient balance! Balance: " + balance);
        }
    }
}

class UserTransaction extends Thread {
    BankAccount account;
    String user, type;
    int amount;

    UserTransaction(BankAccount acc, String user, String type, int amount) {
        this.account = acc;
        this.user = user;
        this.type = type;
        this.amount = amount;
    }

    public void run() {
        if (type.equals("deposit")) {
            account.deposit(user, amount);
        } else {
            account.withdraw(user, amount);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount();

        UserTransaction t1 = new UserTransaction(acc, "User1", "deposit", 2000);
        UserTransaction t2 = new UserTransaction(acc, "User2", "withdraw", 3000);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: " + acc.balance);
    }
}
