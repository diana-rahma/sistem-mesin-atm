import java.util.Scanner;
public class Pembayaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int kodeBayar;
        long jumlahBayar;
        String struk;

        System.out.print("Masukkan kode bayar anda : ");
        kodeBayar = input.nextInt();
        System.out.print("Masukkan nominal yang akan anda bayar : ");
        jumlahBayar = input.nextLong();
        System.out.println("Apakah anda ingin mencetak struk pembayaran? (iya/tidak)");
        struk = input.next();

        if (struk.equals("iya")) {
            System.out.println("Pembayaran telah berhasil! Silahkan ambil struk anda.");
        } else {
            System.out.println("Silahkan kembali ke menu utama");
        }
    }
}
