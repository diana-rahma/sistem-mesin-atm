import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Arrays;;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Now, Now2, Past, New, New2, pilihan, kodeBayar, kodeInstitusi, noRek;
        long Nominal, jmlSaldo, sisa, jumlahBayar, tagihan;
        String Menu, konfirmasi, Nama, Struk, next, name, Asal, Profesi, jenisBayar, data, jenisRek;

        String[][] Data = new String[5][5];

        System.out.println("*********************************************");
        System.out.println("**********                         **********");
        System.out.println("**********            ***          **********");
        System.out.println("**********          *****          **********");
        System.out.println("**********        *******          **********");
        System.out.println("**********      **  *****          **********");
        System.out.println("**********    *     *****          **********");
        System.out.println("**********          *****          **********");
        System.out.println("**********          *****          **********");
        System.out.println("**********          *****          **********");
        System.out.println("**********     ***************     **********");
        System.out.println("**********    *****************    **********");
        System.out.println("**********                         **********");
        System.out.println("*********************************************");
        System.out.println("*             SISTEM MESIN ATM              *");
        System.out.println("*********************************************");
        System.out.println("                                             "); 
        // apakah pengguna memiliki akun atau tidak
            System.out.println("Apakah anda memiliki akun? ");
            System.out.println("1. Ya");
            System.out.println("2. Tidak");
            konfirmasi = input.next();
//Login
                if (konfirmasi.equalsIgnoreCase("1")) {
                    System.out.println("Masukkan Nama anda : ");
                    Nama = input.next();

                    do {
                        System.out.println("Masukkan PIN anda : ");
                        Now = input.nextInt();
                    } while (Now != 12345678);
// Registrasi
                } else {
                    System.out.println("Silakan Registrasi terlebih dahulu.");

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

        System.out.println("Apakah ingin melanjutkan Transaksi ?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        konfirmasi = input.next("1");
        if (konfirmasi.equalsIgnoreCase("1")) {

            // Menu
            System.out.println("Menu");
            System.out.println("1. Tarik Tunai ");
            System.out.println("2. Informasi Saldo");
            System.out.println("3. Pembayaran");
            System.out.println("4. Ubah PIN");
            System.out.println("5. Setor Tunai");
            System.out.println("6. Transfer");
            System.out.println("7. Registrasi");
            System.out.println("0. Keluar");
            
            System.out.println("Silahkan Pilih salah satu menu di atas! ");
            input.nextLine();

            Menu = input.nextLine();
//Tarik Tunai
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

//Informasi Saldo
                case "2":
                    System.out.println("Saldo anda tersisa: XXXXXXXXXXXX ");
                    break;

//Pembayaran
                case "3":
                    System.out.println("Silahkan pilih jenis pembayaran / pembelian");
                    System.out.println("1. Angsuran ");
                    System.out.println("2. Asuransi ");
                    System.out.println("3. Pajak");
                    System.out.println("4. Kartu Kredit");
                    jenisBayar = input.next();

                    switch (jenisBayar) {
                        case "1":
                            System.out.print("Masukkan kode institusi : ");
                            kodeInstitusi = input.nextInt();
                            System.out.print("Masukkan kode pembayaran : ");
                            kodeBayar = input.nextInt();
                            System.out.print("Masukkan Jumlah bayar anda : ");
                            jumlahBayar = input.nextLong();
                            System.out.println("Apakah anda yakin untuk melakukan transaksi? y/t");
                            data = input.next();
                            if (data.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                            } else {
                                System.out.println("Silahkan kembali ke menu utama");
                            }
                            break;
                        
                        case "2":
                            System.out.print("Masukkan kode institusi : ");
                            kodeInstitusi = input.nextInt();
                            System.out.print("Masukkan kode pembayaran : ");
                            kodeBayar = input.nextInt();
                            System.out.println("Cek kebenaran data. Benar/Tidak");
                            data = input.next();
                            if (data.equals("Benar")) {
                                System.out.println("Konfirmasi pembayaraan. y/t");
                                konfirmasi = input.next();
                                if(konfirmasi.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                                }
                            } else {
                                System.out.println("Silahkan cek kembali data");
                            }
                            break;
                        
                        case "3":
                            System.out.print("Masukkan kode tagihan : ");
                            tagihan = input.nextLong();
                            System.out.println("Cek Kebenaran data. Benar/Tidak");
                            data = input.next();
                            System.out.println("Apakah anda yakin untuk membayar y/t");
                                konfirmasi = input.next();
                                if (konfirmasi.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                                } else {
                                    System.out.println("Silahkan kembali ke menu");
                                }
                            System.out.println("Pilih jenis rekening : Rekening Tabungan/Rekening Giro ");
                            jenisRek = input.next();
                            if (jenisRek.equals("Rekening Tabungan")) {
                                System.out.println("Konfirmasi pembayaran dengan tabungan rekening. y/t");
                                konfirmasi = input.next();
                                if (konfirmasi.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                                } else {
                                    System.out.println("Silahkan kembali ke menu");
                                }
                            } else if (jenisRek.equals("Rekening Giro")) {
                                 System.out.print("Konfirmasi Pembayaran dengan tabungan giro. y/t");
                                konfirmasi = input.next();
                                if (konfirmasi.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                                } else {
                                    System.out.println("Silahkan kembali ke menu");
                                }
                            }
                            break;

                        case "4":
                            System.out.print("Masukkan nomor kartu kredit yang akan dibayar : ");
                            noRek = input.nextInt();
                            System.out.print("Masukkan nominal pembayaran yang harus dibayar : ");
                            jumlahBayar = input.nextLong();
                            System.out.println("Apakah data sudah benar? y/t ");
                            data = input.next();
                            if (data.equals("y")) {
                                    System.out.println("Pembayaran akan diproses");
                            } else {
                                System.out.println("Silahkan kembali ke menu utama");
                            }
                            break;

                        default:
                        }

                        break;
// mengganti PIN yang lama dengan yang baru.
                case "4":
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

//Setor Tunai
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

//Transfer                    
                case "6":
                    System.out.println("Masukkan Jumlah uang transfer");
                    break;

//Registrasi
                case "7":
                    System.out.println("Silakan Registrasi terlebih dahulu.");

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

                    
                    default:
                    System.out.println("Menu tidak tersedia ");
            }
        }

        System.out.println("<< Terima Kasih telah menggunakan ATM kami >>");
        System.out.println("<<<< Jika ingin melakukan Transaksi Lain >>>>");
        System.out.println("<<<<<<<<<<< Silahkan Run Kembali >>>>>>>>>>>>");
        System.out.println("<<<<<<<<<<<<<< Terima Kasih >>>>>>>>>>>>>>>>>");
    }
}
