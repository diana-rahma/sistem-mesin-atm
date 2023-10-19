import java.util.Scanner;

public class TarikTunai {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        boolean struk=true;
        long nominaltarik;
        String Nama;

        System.out.println("Masukkan nama Anda: ");
        Nama=input.nextLine();
        System.out.println("Masukkan Nominal Tarik: ");
        nominaltarik=input.nextLong();
        System.out.println("Apakah anda ingin menyetak Struk? ");
        struk=input.nextBoolean();

        if (struk)
        System.out.println("Silahkan ambil struk dan uang anda");
        else 
        System.out.println("Silahkan ambil uang anda");
    }

}