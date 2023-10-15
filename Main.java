import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Now, Past, New, pilihan;
        boolean struk = true;
        long NominalTransaksi, Nominal;
        String Menu, konfirmasi, Nama;

        // apakah pengguna memiliki akun atau tidak
        System.out.println("Apakah anda memiliki akun? (ada/tidak)");
        konfirmasi = input.next();

        if (konfirmasi.equals("ada")) {
            System.out.println("Masukkan Nama anda : ");
            Nama = input.next();

                do {
                System.out.println("Masukkan PIN anda : ");
                Now = input.nextInt();

                continue;
                } while (Now != 12345678);
            
        } else {
            System.out.println("Silakan membuat akun terlebih dahulu.");

            System.out.println("Masukkan nama anda : ");
            Nama=input.next();

            do {               
                System.out.println("Masukkan PIN anda : ");
                Now=input.nextInt();

                System.out.println("Masukkan PIN anda kembali : ");
                New=input.nextInt();

                if (Now == New) {
                    System.out.println("Selamat !! Akun anda telah terdaftar");           
                } else {
                    System.out.println("PIN anda tidak sama ");
                } 
            } while (Now != New);
        }

        // Menu
        

        System.out.println("Menu : (Tarik Tunai) (Informasi Saldo) (Pembayaran) (Ubah PIN)");
        System.out.println("Silahkan Pilih salah satu menu di atas! ");
        input.nextLine(); 
        Menu = input.nextLine(); 

        switch (Menu) {
            case "Tarik Tunai":
                System.out.println("Masukkan Nominal Transaksi yang anda inginkan ");
                NominalTransaksi = input.nextLong();
                System.out.println("Masukkan Nominal yang anda ingin tarik ");
                Nominal = input.nextLong();
                System.out.println("Apakah anda ingin mencetak struk ?");
                struk = input.nextBoolean();
                if (struk) {
                    System.out.println("Jangan lupa ambil struk dan uang senilai " + NominalTransaksi);
                } else {
                    System.out.println("Jangan lupa ambil uang senilai " + NominalTransaksi);
                }
                break;

            case "Informasi Saldo":
                System.out.println("Saldo anda tersisa: XXXXXXXXXXXX ");
                break;

            case "Pembayaran":
                System.out.println("Silahkan melakukan pembayaran ");
                break;

            case "Ubah PIN":
                System.out.println("Masukkan PIN lama anda ");
                Past = input.nextInt();
                System.out.println("Masukkan PIN baru anda");
                New = input.nextInt(); //  mengganti PIN yang lama dengan yang baru.
                System.out.println("Pin anda telah diganti ");
                break;

            default:
                System.out.println("Menu tidak tersedia ");
        }

        System.out.println("Terima Kasih telah menggunakan ATM kami :) ");
    }
}
