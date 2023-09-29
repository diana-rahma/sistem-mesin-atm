import java.util.Scanner;

public class Registrasi {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        String Nama, Umur, Asal;
        int TglLhr, Pass;

        System.out.println("Registrasi Akun");
        System.out.println("Nama            :");
        Nama=input.next();
        System.out.println("Umur            :");
        Umur=input.next();
        System.out.println("Asal            :");
        Asal=input.next();
        System.out.println("Tanggal Lahir   :");
        TglLhr=input.nextInt();
        System.out.println("Password            :");
        Pass=input.nextInt();
        System.out.println(" Registrasi Berhasil ");
        System.out.println("Berikut Data Anda");
        System.out.println("Nama            :" + Nama);
        System.out.println("Umur            :" + Umur);
        System.out.println("Asal            :" + Asal);
        System.out.println("Tanggal Lahir   :" + TglLhr);


        

    }
}