import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Now=12345678;
        String nama;
        System.out.println("Masukkan nama anda: ");
        nama = input.nextLine();

        do {
            System.out.println("Masukkan PIN anda : ");
            Now = input.nextInt();
            if(Now == 12345678) {
                continue;
            }
        } while (Now != 12345678);
    }
}
