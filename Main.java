import java.util.Scanner;

import java.util.Arrays;;

public class Main {
    static String[][] akunUser = {
    {"Diana", "12345678", "150000000"},
    {"Varizky", "87654321", "200000000"},
    {"Romy", "12341234", "100000000"}
};

    static String konfirmasi, Struk;
    static long jmlSaldo = 150000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Now, Now2, Past, New, New2, pilihan, kodeBayar, kodeInstitusi, noRek, kodeBank, bankTujuan;
        long Nominal, sisa, jumlahBayar, tagihan, nominalTransfer;
        String Menu, Nama, Struk, Asal, Profesi, jenisBayar, jenisRek;


        System.out.println("*********************************************");
        System.out.println("*             SISTEM MESIN ATM              *");
        System.out.println("*********************************************");
    
        // apakah pengguna memiliki akun atau tidak
        System.out.println("Apakah anda memiliki akun? ");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        String konfirmasi = sc.next();
        // Login
        if (konfirmasi.equalsIgnoreCase("1")) {
            login();
        } else {
            System.out.print("Masukkan Nama Anda : ");
            Nama = sc.nextLine();
            System.out.print("Masukkan Asal Anda : ");
            Asal = sc.nextLine();
            System.out.print("Masukkan Profesi Anda : ");
            Profesi = sc.nextLine();
            registrasi(Nama , Asal , Profesi);

        System.out.println("Apakah ingin melanjutkan Transaksi ?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        konfirmasi = sc.next("1");
        if (konfirmasi.equals("1")) {

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
            sc.nextLine();

            Menu = sc.nextLine();
            switch (Menu) {
            // Tarik Tunai
            case "1":
            
            System.out.println("Masukkan Nama anda");
            Nama = sc.nextLine();

            System.out.println("Masukkan Nominal yang ingin Anda tarik ");
            Nominal = sc.nextLong();
                
            tarikTunai(Nama , Nominal);
            break;

    
                // Informasi Saldo
                case "2":
                    System.out.println("Saldo anda tersisa : " );
                    break;

                // Pembayaran
                case "3":
                    System.out.println("Silahkan pilih jenis pembayaran / pembelian");
                    System.out.println("1. Angsuran ");
                    System.out.println("2. Asuransi ");
                    System.out.println("3. Pajak");
                    System.out.println("4. Kartu Kredit");
                    jenisBayar = sc.next();

                    switch (jenisBayar) {
                        case "1":
                            System.out.print("Masukkan kode institusi : ");
                            kodeInstitusi = sc.nextInt();
                            System.out.print("Masukkan kode pembayaran : ");
                            kodeBayar = sc.nextInt();
                            System.out.print("Masukkan Jumlah bayar anda : ");
                            jumlahBayar = sc.nextLong();
                            opsiTransaksi();
                            break;

                        case "2":
                            System.out.print("Masukkan kode institusi : ");
                            kodeInstitusi = sc.nextInt();
                            System.out.print("Masukkan kode pembayaran : ");
                            kodeBayar = sc.nextInt();
                            System.out.println("Masukkan jumlah tagihan yang akan dibayar");
                            tagihan = sc.nextLong();
                            opsiTransaksi();
                            break;

                        case "3":
                            System.out.print("Masukkan kode tagihan : ");
                            tagihan = sc.nextLong();
                            System.out.println("Masukkan jumlah tagihan");
                            tagihan = sc.nextLong();
                            System.out.println("Pilih jenis rekening : ");
                            System.out.println("1. Rekening Tabungan");
                            System.out.println("2. Rekening Giro");
                            System.out.println("3. Lainnya");
                            jenisRek = sc.next();
                            if (jenisRek.equals("1")) {
                                konfirmasiPembayaran();
                            } else if (jenisRek.equals("2")) {
                                konfirmasiPembayaran();
                            }  else {
                                System.out.println("Masukkan jenis rekening tabungan anda : ");
                                jenisRek = sc.next();
                                konfirmasiPembayaran();
                            }
                            break;

                        case "4":
                            System.out.print("Masukkan nomor kartu kredit yang akan dibayar : ");
                            noRek = sc.nextInt();
                            System.out.print("Masukkan nominal pembayaran yang harus dibayar : ");
                            jumlahBayar = sc.nextLong();
                            opsiTransaksi();
                            break;

                        default:
                    }

                    break;
                // mengganti PIN yang lama dengan yang baru.
                case "4":
                    do {
                        System.out.println("Masukkan PIN anda Sekarang : ");
                        Now = sc.nextInt();

                        System.out.println("Masukkan PIN Baru anda : ");
                        New = sc.nextInt();

                        System.out.println("Masukkan kembali PIN Baru Anda ");
                        New2 = sc.nextInt();

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
                    Nominal = sc.nextLong();
                    System.out.println("Apakah anda ingin untuk mencetak struk?");
                    System.out.println("1. Iya");
                    System.out.println("2. Tidak");
                    Struk = sc.next();
                    if (Struk.equals("1")) {
                        System.out.println("Silahkan ambil struk anda.");
                    } else {
                        System.out.println("Silahkan kembali ke menu utama");
                    }
                    break;

                // Transfer
                case "6":
                System.out.println("Masukkan kode bank anda");
                kodeBank = sc.nextInt();
                System.out.println("Masukkan kode bank tujuan anda: ");
                bankTujuan = sc.nextInt();
                System.out.println("Masukkan nominal transfer anda");
                nominalTransfer = sc.nextLong();
                
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
                    Nama = sc.next();

                    while (true) {

                        System.out.println("Darimana Anda Berasal : ");
                        Asal = sc.next();

                        System.out.println("Apa Profesi Anda : ");
                        Profesi = sc.next();

                        break;
                    }

                    do {
                        System.out.println("Masukkan PIN anda : ");
                        Now = sc.nextInt();

                        System.out.println("Masukkan PIN anda kembali : ");
                        Now2 = sc.nextInt();
                        
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
    //FUNGSI FUNGSI AN

    // Login User
    static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = sc.next();
        System.out.print("Masukkan PIN: ");
        String pinUser = sc.next();

        boolean status = cek(nama, pinUser);

        if (status) {
            System.out.println("Login berhasil! Selamat datang, " + nama + "!");
            // Tambahkan logika untuk menu transaksi setelah login berhasil
        } else {
            System.out.println("Login gagal. Nama atau PIN  salah.");
        }
    }
    
    // End Login User 
    
    // Fungsi cek akun user
    static boolean cek(String nama, String pinUser) {
        for (String[] user : akunUser) {
            if (user[0].equals(nama) && user[1].equals(pinUser)) {
                return true;
            }
        }
        return false;
    }

    static void registrasi(String Nama, String Asal, String Profesi) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Masukkan PIN anda : ");
        String now = sc.next();
        System.out.println("Masukkan PIN anda kembali : ");
        String now2 = sc.next();

        if (now.equals(now2)) {
            System.out.println("Selamat !! Akun anda telah terdaftar");
            System.out.println("Nama = " + Nama);
            System.out.println("Asal = " + Asal);
            System.out.println("Profesi = " + Profesi);

            String[] akunBaru = {Nama, now, "0"}; // Saldo awal = 0
            akunUser = Arrays.copyOf(akunUser, akunUser.length + 1);
            akunUser[akunUser.length - 1] = akunBaru;
        } else {
            System.out.println("PIN anda tidak sama ");
        }
    }
  // Menu

            // System.out.println("1. Tarik Tunai ");
    static void tarikTunai(String Nama, long Nominal) {

        if (Nominal > jmlSaldo) {
                System.out.println("Maaf, saldo tidak mencukupi.");
            } else {
                jmlSaldo -= Nominal;
                updateSaldo(Nama, jmlSaldo);
                Struk(Nominal, Nama);
                
            }
                
            }

            // System.out.println("2. Informasi Saldo");

    static void InformasiSaldo() {
                
            }

            // System.out.println("3. Pembayaran");

    static void pembayaran() {
                
            }
            // System.out.println("4. Ubah PIN");

    static void ubahPIN() {
                
            }

            // System.out.println("5. Setor Tunai");


    static void penyetoran() {
                
            }

            // System.out.println("6. Transfer");

    static void Transfer() {
                
            }
            

    // Konfirmasi pembayaran jenis tabungan
    static void konfirmasiPembayaran() {
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
    static void opsiTransaksi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Apakah anda yakin untuk melakukan transaksi?");
        System.out.println("1. Iya");
        System.out.println("2. Tidak");
        String data = sc.next();
        if (data.equals("1")) {
            System.out.println("Pembayaran akan diproses");
        } else {
            System.out.println("Silahkan kembali ke menu utama");
        }
    }
    // End Konfirmasi transaksi pengguna

    static void updateSaldo(String nama, long newSaldo) {
        for (String[] user : akunUser) {
            if (user[0].equals(nama)) {
                user[2] = String.valueOf(newSaldo);
                break;
            }
        }
    }

    static long getSaldo(String nama) {
        for (String[] user : akunUser) {
            if (user[0].equals(nama)) {
                return Long.parseLong(user[2]);
            }
        }
        return 0;
    }

    // Cetak Struk
    static void Struk(long Nominal, String Nama) {
        if (Struk.equals("1")) {
            System.out.println("Silahkan ambil uang senilai " + Nominal + " dan struk anda.");
            System.out.println("Sisa saldo anda sekarang: " + getSaldo(Nama));
        } else {
            System.out.println("Silahkan ambil uang Anda senilai " + Nominal);
            System.out.println("Sisa saldo anda sekarang: " + getSaldo(Nama));
        }
    }
    // End Cetak Struk
}

    


