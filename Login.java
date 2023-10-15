import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Now=12345678;
        System.out.println("Masukkan PIN ATM anda: ");
        Now = input.nextInt();

        do {
            System.out.println("Masukkan PIN anda : ");
            Now = input.nextInt();
            if(Now == 12345678) {
                continue;
            }
        } while (Now != 12345678);
    }
}
