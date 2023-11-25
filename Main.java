import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.Arrays;;

public class Main {
    static String[][] akunUser = {
        {"Diana", "12345678"},
        {"Varizky", "87654321"},
        {"Romy", "12341234"}
    };
    static String konfirmasi, data, Struk;
    static long Nominal;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int Now, Now2, Past, New, New2, pilihan, kodeBayar, kodeInstitusi, noRek, kodeBank, bankTujuan;
        long jmlSaldo, sisa, jumlahBayar, tagihan, nominalTransfer;
        String Menu, konfirmasi, Nama, Struk, next, name, Asal, Profesi, jenisBayar, data, jenisRek;

        long[] saldo = {150000000};

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
        // Login
        if (konfirmasi.equalsIgnoreCase("1")) {
            login();
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
            // Tarik Tunai
            switch (Menu) {
                case "1":
                    System.out.println("Masukkan Nominal yang ingin Anda tarik ");
                    Nominal = input.nextLong();
                    Struk();
                    
                    break;

                // Informasi Saldo
                case "2":
                    System.out.println("Saldo anda tersisa : " +saldo[0]);
                    break;

                // Pembayaran
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
                            opsiTransaksi();
                            break;

                        case "2":
                            System.out.print("Masukkan kode institusi : ");
                            kodeInstitusi = input.nextInt();
                            System.out.print("Masukkan kode pembayaran : ");
                            kodeBayar = input.nextInt();
                            System.out.println("Masukkan jumlah tagihan yang akan dibayar");
                            tagihan = input.nextLong();
                            opsiTransaksi();
                            break;

                        case "3":
                            System.out.print("Masukkan kode tagihan : ");
                            tagihan = input.nextLong();
                            System.out.println("Masukkan jumlah tagihan");
                            tagihan = input.nextLong();
                            System.out.println("Pilih jenis rekening : ");
                            System.out.println("1. Rekening Tabungan");
                            System.out.println("2. Rekening Giro");
                            System.out.println("3. Lainnya");
                            jenisRek = input.next();
                            if (jenisRek.equals("1")) {
                                konfirmasiPembayaran();
                            } else if (jenisRek.equals("2")) {
                                konfirmasiPembayaran();
                            }  else {
                                System.out.println("Masukkan jenis rekening tabungan anda : ");
                                jenisRek = input.next();
                                konfirmasiPembayaran();
                            }
                            break;

                        case "4":
                            System.out.print("Masukkan nomor kartu kredit yang akan dibayar : ");
                            noRek = input.nextInt();
                            System.out.print("Masukkan nominal pembayaran yang harus dibayar : ");
                            jumlahBayar = input.nextLong();
                            opsiTransaksi();
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

                // Setor Tunai
                case "5":
                    System.out.println("Masukkan nominal uang anda : ");
                    Nominal = input.nextLong();
                    System.out.println("Apakah anda ingin untuk mencetak struk?");
                    System.out.println("1. Iya");
                    System.out.println("2. Tidak");
                    Struk = input.next();
                    if (Struk.equals("1")) {
                        System.out.println("Silahkan ambil struk anda.");
                    } else {
                        System.out.println("Silahkan kembali ke menu utama");
                    }
                    break;

                // Transfer
                case "6":
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
                    System.out.println();
                    break;

                // Registrasi
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

    // Cetak Struk
    static void Struk() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Apakah Anda ingin mencetak struk?");        
            System.out.println("1. Iya");
            System.out.println("2. Tidak");
            Struk = sc.next();

            if (Struk.equals("1")) {
                System.out.println("Silahkan ambil uang senilai "+ Nominal +" dan struk anda.");
            } else {
                System.out.println("Silahkan ambil uang Anda senilai");
            }
    }
    // End Cetak Struk

    // Login User
    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = sc.next();
        System.out.print("Masukkan PIN: ");
        String pinUser = sc.next();

        boolean status = cek(nama, pinUser);

        if (status) {
            System.out.println("Login berhasil! Selamat datang, " + nama + "!");
        } else {
            System.out.println("Login gagal. Nama atau PIN  salah.");
        }
    }
    public static boolean cek(String nama, String pinUser) {
        for (String[] user : akunUser) {
            if (user[0].equals(nama) && user[1].equals(pinUser)) {
                return true; 
            }
        }
        return false;
    }
    // End Login User 


    // Konfirmasi pembayaran jenis tabungan
    public static void konfirmasiPembayaran() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Konfirmasi pembayaran dengan tabungan tersebut");
            System.out.println("1. Iya");
            System.out.println("2. Tidak");
            konfirmasi = sc.next();
            if (konfirmasi.equals("1")) {
                System.out.println("Pembayaran akan diproses");
            } else {
                System.out.println("Silahkan kembali ke menu");
            }
    }
    //  End konfirmasi pembayaran jenis tabungan

    // Konfirmasi transaksi pengguna
    public static void opsiTransaksi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Apakah anda yakin untuk melakukan transaksi?");
            System.out.println("1. Iya");
            System.out.println("2. Tidak");
            data = sc.next();
            if (data.equals("1")) {
                System.out.println("Pembayaran akan diproses");
            } else {
                System.out.println("Silahkan kembali ke menu utama");
            }
    }
    // End Konfirmasi transaksi pengguna
}  
