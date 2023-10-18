package jobsheet6;
import java.util.Scanner;

public class Transfer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long nominalTransfer;
        int noRek, kodeBank, bankTujuan;

        System.out.println("Masukkan kode bank anda");
        kodeBank = input.nextInt();  // Assuming kodeBank represents your source bank code
        System.out.println("Masukkan kode bank tujuan anda: ");
        bankTujuan = input.nextInt();
        System.out.println("Masukkan nominal transfer anda");
        nominalTransfer = input.nextLong();

        if (kodeBank == bankTujuan) {
            if (bankTujuan == kodeBank) {
                if (nominalTransfer >= 500000) {
                    System.out.println("Bebas biaya admin");
                } else {
                    System.out.println("Anda dikenakan biaya admin sebesar 5000");
                }
            } else {
                System.out.println("Biaya admin sebesar 10000");
            }
        } else {
            System.out.println("Biaya admin 15000");
        }
    }
}
