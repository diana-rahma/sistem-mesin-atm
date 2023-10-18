import java.util.Scanner;

public class SetorTunai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long Nominal;
        String struk;

        System.out.println("Masukkan nominal uang anda : ");
        Nominal = input.nextLong();
        System.out.println("Apakah anda ingin untuk mencetak struk? (iya/tidak)"); 
        struk = input.next();
        
        if (struk.equals("iya")) {
            System.out.println("Silahkan ambil struk anda.");
        } else {
            System.out.println("Silahkan kembali ke menu utama");
        }
    }
}
