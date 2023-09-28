import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int New, Old;
        boolean struk=true;
        long NominalTransaksi;
        String Menu;

        System.out.println("Menu : (Registrasi) (Tarik Tunai) (Informasi Saldo) (Pembayaran) (Ubah PIN)");
        System.out.println("Silahkan Pilih salah satu menu diatas ! ");
        Menu = input.nextLine();

        switch(Menu){
            case "Registrasi":
                System.out.println(" Silahkan buat Akun terlebih dahulu ");
                break;

            case "Tarik Tunai":
                System.out.println(" Masukkan Nominal Transaksi yang anda ingin kan ");
                NominalTransaksi=input.nextLong();
                System.out.println(" Apakah anda ingin mencetak struk ?");
                struk=input.nextBoolean();           
                    if (struk)
                        System.out.println(" Jangan lupa ambil struk dan uang senilai " + NominalTransaksi);    
                    else 
                        System.out.println(" Jangan lupa ambil uang senilai " + NominalTransaksi);
                break;

            case "Informasi Saldo":
                System.out.println(" Saldo anda tersisa : XXXXXXXXXXXX ");
                break;

            case "Pembayaran":
                System.out.println(" Silahkan melakukan pembayaran ");
                break;

            case "Ubah PIN":
                System.out.println("Masukkan PIN lama anda ");
                Old=input.nextInt();
                System.out.println("Masukkan PIN baru anda");
                New=input.nextInt();
                System.out.println("Pin anda telah diganti ");
                break;
                
            default:
                System.out.println(" Menu tidak tersedia ");
            
        }
                System.out.println(" Terima Kasih telah menggunakan ATM kami :) ");
    }
}