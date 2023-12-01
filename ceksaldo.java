import java.util.Scanner;

public class ceksaldo {
    private int balance;

    public ceksaldo(int initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + this.balance);
    }

    public void withdraw(int amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance.");
        } else {
            this.balance -= amount;
            System.out.println("You have withdrawn " + amount + ". Your new balance is: " + this.balance);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan saldo awal:");
        int initialBalance = input.nextInt();
        ceksaldo myAccount = new ceksaldo(initialBalance);

        System.out.println("Masukkan jumlah penarikan:");
        int amount = input.nextInt();
        myAccount.withdraw(amount);

        myAccount.checkBalance();
    }
}
