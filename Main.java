import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Arrays;;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Now, Now2, Past, New, New2, pilihan, kodeBayar, kodeInstitusi, noRek;
        long Nominal, jmlSaldo, sisa, jumlahBayar, tagihan;
        String Menu, konfirmasi, Nama, Struk, next, name, Asal, Profesi, jenisBayar, data;

        String[][] Data = new String[5][5];

        // apakah pengguna memiliki akun atau tidak
        System.out.println("Apakah anda memiliki akun? (y/t)");
        konfirmasi = input.next();

        if (konfirmasi.equalsIgnoreCase("y")) {
            System.out.println("Masukkan Nama anda : ");
            Nama = input.next();

            do {
                System.out.println("Masukkan PIN anda : ");
                Now = input.nextInt();
            } while (Now != 12345678);

        } else {
            System.out.println("Silakan membuat akun terlebih dahulu.");

            System.out.println("Masukkan Nama Anda : ");
            Nama = input.next();

            while (true) {

                System.out.println("Darimana Anda Berasal : ");
                Asal = input.next();

                System.out.println("Apa Profesi Anda : ");
                Profesi = input.next();

                break;
            }

            do {
                System.out.println("Masukkan PIN anda : ");
                Now = input.nextInt();

                System.out.println("Masukkan PIN anda kembali : ");
                Now2 = input.nextInt();

                if (Now == Now2) {
                    System.out.println("Selamat !! Akun anda telah terdaftar");
                    System.out.println("Nama = " + Nama);
                    System.out.println("Asal = " + Asal);
                    System.out.println("Profesi = " + Profesi);
                } else {
                    System.out.println("PIN anda tidak sama ");
                }

            } while (Now != Now2);

        }

        System.out.println("Apakah ingin melanjutkan Transaksi ? y/t");
        konfirmasi = input.next("y");

        if (konfirmasi.equalsIgnoreCase("y")) {
            // Menu
            System.out.println("Menu : (1)Tarik Tunai (2)Informasi Saldo (3)Pembayaran (4)Ubah PIN (5)Setor Tunai (6)Transfer");
            System.out.println("Silahkan Pilih salah satu menu di atas! ");
            input.nextLine();

            Menu = input.nextLine();

            switch (Menu) {
                case "1":
                    System.out.println("Masukkan Nominal yang ingin Anda tarik ");
                    Nominal = input.nextLong();

                    System.out.println("Apakah Anda ingin mencetak struk ? iya/tidak");
                    Struk = input.next();

                    if (Struk.equals("iya")) {
                        System.out.println("Silahkan ambil uang senilai" + Nominal + " dan struk anda.");
                    } else {
                        System.out.println("Silahkan ambil uang Anda senilai" + Nominal);
                    }
                    break;

                case "2":
                    System.out.println("Saldo anda tersisa: XXXXXXXXXXXX ");
                    break;

                case "3":
                    System.out.println("Silahkan pilih jenis pembayaran / pembelian");
                    System.out.println("(1)Angsuran (2)Asuransi (3)Pajak (4)Kartu Kredit");

                case "4":
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

                case "5":
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

                case "6":
                    System.out.println("Masukkan Jumlah uang transfer");
                    break;

                default:
                    System.out.println("Menu tidak tersedia ");
            }
        }

        System.out.println("Terima Kasih telah menggunakan ATM kami :) ");
    }
}
