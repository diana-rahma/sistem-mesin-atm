import java.util.Scanner;

public class Transfer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long nominalTransfer;
        int noRek, kodeBank, bankTujuan;

        System.out.println("Masukkan kode bank anda");
        kodeBank = input.nextInt();
        System.out.println("Masukkan kode bank tujuan anda: ");
        bankTujuan = input.nextInt();
        System.out.println("Masukkan nominal transfer anda");
        nominalTransfer = input.nextLong();

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 1 && j == 1) {
                    if (kodeBank == bankTujuan) {
                        if (nominalTransfer >= 500000) {
                            System.out.println("Bebas biaya admin");
                        } else {
                            System.out.println("Anda dikenakan biaya admin sebesar 5000");
                        }
                    }
                } else if (i == 1 && j == 2) {
                    if (bankTujuan == kodeBank) {
                        System.out.println("Biaya admin sebesar 10000");
                    }
                } else if (i == 2 && j == 2) {
                    System.out.println("Biaya admin 15000");
                }
            }
        }
    }
}