import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Now, Now2, Past, New, New2, pilihan, kodeBayar;
        long Nominal, jmlSaldo, sisa, jumlahBayar;
        String Menu, konfirmasi, Nama, Struk;

        // apakah pengguna memiliki akun atau tidak
        System.out.println("Apakah anda memiliki akun? (ada/tidak)");
        konfirmasi = input.next();

        if (konfirmasi.equals("ada")) {
            System.out.println("Masukkan Nama anda : ");
            Nama = input.next();

            do {
                System.out.println("Masukkan PIN anda : ");
                Now = input.nextInt();
            } while (Now != 12345678);

        } else {
            System.out.println("Silakan membuat akun terlebih dahulu.");

            System.out.println("Masukkan nama anda : ");
            Nama = input.next();

            do {
                System.out.println("Masukkan PIN anda : ");
                Now = input.nextInt();

                System.out.println("Masukkan PIN anda kembali : ");
                Now2 = input.nextInt();

                if (Now == Now2) {
                    System.out.println("Selamat !! Akun anda telah terdaftar");
                } else {
                    System.out.println("PIN anda tidak sama ");
                }
            } while (Now != Now2);
        }

        // Menu
        System.out.println("Menu : (Tarik Tunai) (Informasi Saldo) (Pembayaran) (Ubah PIN) (Setor Tunai)");
        System.out.println("Silahkan Pilih salah satu menu di atas! ");
        input.nextLine(); // Konsumsi karakter baru setelah memasukkan apakah Anda ingin mencetak struk

        Menu = input.nextLine(); // Baca seluruh baris yang dimasukkan pengguna

        switch (Menu) {
            case "Tarik Tunai":
                System.out.println("Masukkan Nominal yang ingin Anda tarik ");
                Nominal = input.nextLong();
                
                System.out.println("Apakah Anda ingin mencetak struk ? iya/tidak");
                Struk = input.next();
                
                if (Struk.equals("iya")) {
                    System.out.println("Silahkan ambil struk anda.");
                } else {
                    System.out.println("Silahkan kembali ke menu utama");
                }
                break;

            case "Informasi Saldo":
                System.out.println("Saldo anda tersisa: XXXXXXXXXXXX ");
                break;

            case "Pembayaran":
                System.out.print("Masukkan kode bayar anda : ");
                kodeBayar = input.nextInt();
                System.out.print("Masukkan nominal yang akan anda bayar : ");
                jumlahBayar = input.nextLong();
                System.out.println("Apakah anda ingin mencetak struk pembayaran? (iya/tidak)");
                Struk = input.next();

                if (Struk.equals("iya")) {
                    System.out.println("Pembayaran telah berhasil! Silahkan ambil struk anda.");
                } else {
                    System.out.println("Silahkan kembali ke menu utama");
                }
                break;

            case "Ubah PIN":
                // mengganti PIN yang lama dengan yang baru.
                do {
                    System.out.println("Masukkan PIN anda Sekarang : ");
                    Now = input.nextInt();

                    System.out.println("Masukkan PIN Baru anda : ");
                    New = input.nextInt();

                    System.out.println("Masukkan kembali PIN Baru Anda ");
                    New2 = input.nextInt();

                    if (Now == New) {
                        System.out.println("PIN baru anda sama dengan PIN sekarang");

                        if (New != New2) {
                            System.out.println("PIN Baru anda berbeda");
                        }
                    }
                } while ((New != New2) && (Now != New2));

                System.out.println("Pin anda telah diganti ");
                break;

            case "Setor Tunai":
                System.out.println("Masukkan nominal uang anda : ");
                Nominal = input.nextLong();
                System.out.println("Apakah anda ingin untuk mencetak struk? (iya/tidak)");
                Struk = input.next();

                if (Struk.equals("iya")) {
                    System.out.println("Silahkan ambil struk anda.");
                } else {
                    System.out.println("Silahkan kembali ke menu utama");
                }
                break;

            default:
                System.out.println("Menu tidak tersedia ");
        }

        System.out.println("Terima Kasih telah menggunakan ATM kami :) ");
    }
}
