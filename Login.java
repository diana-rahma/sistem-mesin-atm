import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pin=12345678;
        System.out.println("Masukkan PIN ATM anda: ");
        pin = input.nextInt();

        if (pin==12345678)
            System.out.println("Login berhasil");
        else 
            System.out.println("PIN anda salah, silahkan coba lagi");
    }
}
