import java.util.Scanner;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static String[][] akunUser = {
            { "Diana", "12345678", "150000000" },
            { "Varizky", "87654321", "200000000" },
            { "Romy", "12341234", "100000000" }
    };
    static String[] nama =  {"Diana", "Varizky", "Romy"};
    static int[] pin ={123456, 654321, 111222};
    static long[] saldo = {10000000, 12000000, 5000000};
    static Scanner sc = new Scanner(System.in);
    static String konfirmasi, Struk, Menu;
    static long jmlSaldo = 150000000, Nominal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pilihan, kodeBayar, kodeInstitusi, noRek, kodeBank, bankTujuan;
        long Nominal, sisa, jumlahBayar, tagihan, nominalTransfer;
        String Menu, Nama, Struk, Asal, Profesi, jenisBayar, jenisRek, Now, Now2, Past, New, New2;

        System.out.println("*********************************************");
        System.out.println("*             SISTEM MESIN ATM              *");
        System.out.println("*********************************************");

        // Apakah pengguna memiliki akun atau tidak
        System.out.println("Semua Pilihan hanya menggunakan angka !");
        System.out.println("Apakah anda memiliki akun? ");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        String konfirmasi = sc.next();
        // Login
        if (konfirmasi.equals("1")) {
            boolean loginBerhasil = false;
            do {
                loginBerhasil = login();
            } while (!loginBerhasil);
         
        // Registrasi   
        } else if (konfirmasi.equals("2")){
            System.out.print("Masukkan Nama Anda : ");
            Nama = sc.next();

            System.out.print("Masukkan Asal Anda : ");
            Asal = sc.next();

            System.out.print("Masukkan Profesi Anda : ");
            Profesi = sc.next();

            registrasi(Nama, Asal, Profesi);
        } 
        
        switch (menu()) {
                // Tarik Tunai
                case "1":

                        System.out.println("Masukkan Nama anda");
                        Nama = sc.next();

                        System.out.println("Masukkan Nominal yang ingin Anda tarik ");
                        Nominal = sc.nextLong();

                        tarikTunai(Nama, Nominal);
                        break;

                    // Informasi Saldo
                    case "2":
                        System.out.println("Saldo anda tersisa : ");
                        break;

                    // Pembayaran
                    case "3":
                        pembayaran();
                        break;
                        
                    // mengganti PIN yang lama dengan yang baru.
                    case "4":
                        do {
                            System.out.println("Masukkan PIN anda Sekarang : ");
                            Now = sc.next();

                            System.out.println("Masukkan PIN Baru anda : ");
                            New = sc.next();

                            System.out.println("Masukkan kembali PIN Baru Anda ");
                            New2 = sc.next();

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
                        setorTunai();
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
                            Now = sc.next();

                            System.out.println("Masukkan PIN anda kembali : ");
                            Now2 = sc.next();

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

           
        
    
    // FUNGSI FUNGSI AN

    // Login User
    static boolean login() {
        System.out.print("Masukkan nama : ");
        String nama = sc.next();
        System.out.print("Masukkan PIN  : ");
        String pinUser = sc.next();
        boolean status = cek(nama, pinUser);
        if (status) {
            System.out.println("Login berhasil! Selamat datang, " + nama + "!");
            return true; 
        } else {
            System.out.println("Login gagal. Nama atau PIN  salah.");
            return false;
        }
    }
    static boolean cek(String nama, String pinUser) {
        for (int i = 0; i < akunUser.length; i++) {
            if (akunUser[i][0].equals(nama) && akunUser[i][1].equals(pinUser)) {
                return true; 
            }
        }
        return false;
    }

    // End Login User

    // Registrasi User
    static void registrasi(String Nama, String Asal, String Profesi) {
        Scanner sc = new Scanner(System.in);
        String now, now2;
    
        do {  
            System.out.println("Masukkan PIN anda: ");
            now = sc.next();
            System.out.println("Masukkan PIN anda kembali: ");
            now2 = sc.next();
    
            if (now.equals(now2)) {
                break;
            } else {
                System.out.println("Pin tidak sama");
            }
        } while (true);
    
        System.out.println("Selamat! Akun Anda telah terdaftar");
        System.out.println("Nama = " + Nama);
        System.out.println("Asal = " + Asal);
        System.out.println("Profesi = " + Profesi);
    }
    

    // End Registrasi User

    // Menu
    static String menu() { 
        System.out.println("\n");
        System.out.println("*********************************");
        System.out.println("*             MENU              *");
        System.out.println("*********************************");
        System.out.println("\t * 1. Tarik Tunai ");
        System.out.println("\t * 2. Informasi Saldo ");
        System.out.println("\t * 3. Pembayaran " );
        System.out.println("\t * 4. Ubah PIN ");
        System.out.println("\t * 5. Setor Tunai ");
        System.out.println("\t * 6. Transfer " );
        System.out.println("\t * 7. Registrasi ");
        System.out.println("\t * 0. Keluar " );
        System.out.println("Silahkan Pilih salah satu menu di atas! ");
        sc.nextLine();
        Menu = sc.nextLine();
        return Menu;
    }
    // End Menu

    // Fitur Tarik Tunai

    static void tarikTunai(String Nama, long Nominal) {

        String namaAkun;
        
        //milih akun
        System.out.println("Silakan pilih akun yang akan digunakan untuk tarik tunai:");
        for (int i = 0; i < akunUser.length; i++) {
            System.out.println( (i + 1) + " . " + akunUser[i][0]);
        }
        namaAkun = sc.next();
    
        // periksa saldo
        long saldoAkun = getSaldo(namaAkun);
        if (Nominal > saldoAkun)  {
            System.out.println("Maaf, saldo tidak mencukupi.");
            return;
        }
     
        // Hitung biaya admin
        long biayaAdmin = 0;
        if (Nominal > 500000) {
            biayaAdmin = 5000;
        }
    
        // Jika saldo mencukupi, maka mengurangi saldo akun tersebut.
        updateSaldo(namaAkun, saldoAkun - Nominal , biayaAdmin);
        Struk(Nominal, namaAkun);
    
        System.out.println("Biaya admin: " + biayaAdmin);
        System.out.println("Sisa saldo anda sekarang: " + getSaldo(namaAkun));
    
    }
    
    // End Fitur Tarik Tunai

    // Fitur Informasi Saldo
    static void InformasiSaldo() {

    }
    // End Fitur Informasi Saldo

    // Fitur Pembayaran
    static void pembayaran() {
        String jenisBayar, jenisRek;
        int kodeBayar, noCust;
        long jumlahBayar, tagihan;
        System.out.println("Silahkan pilih jenis pembayaran / pembelian di bawah ini");
        System.out.println("1. Token Listrik ");
        System.out.println("2. Tagihan Air PDAM");
        System.out.println("3. Pajak");
        System.out.println("4. Online Shop");
        jenisBayar = sc.next();

        switch (jenisBayar) {
            case "1":
                System.out.println("<-----Bayar Token Listrik----->");
                System.out.print("Masukkan nomor meter : ");
                kodeBayar = sc.nextInt();
                System.out.print("Masukkan Jumlah bayar anda : ");
                jumlahBayar = sc.nextLong();
                konfirmasiPembayaran();
                struk();
                break;

            case "2":
                System.out.println("-----Bayar Tagihan Air PDAM----");
                System.out.print("Masukkan kode PDAM : ");
                kodeBayar = sc.nextInt();
                System.out.print("Masukkan kode pelanggan : ");
                noCust = sc.nextInt();
                System.out.print("Masukkan jumlah tagihan yang akan dibayar");
                tagihan = sc.nextLong();
                konfirmasiPembayaran();
                break;

            case "3":
                System.out.println("-----Bayar Pajak-----");
                System.out.print("Masukkan kode tagihan : ");
                kodeBayar = sc.nextInt();
                System.out.println("Masukkan jumlah tagihan pajak : ");
                tagihan = sc.nextLong();
                konfirmasiPembayaran();
                break;

            case "4":
                System.out.println("-----Bayar Online Shop-----");
                System.out.print("Masukkan kode bayar : ");
                kodeBayar = sc.nextInt();
                System.out.print("Masukkan nominal pembayaran yang harus dibayar : ");
                jumlahBayar = sc.nextLong();
                konfirmasiPembayaran();
                break;
            default:
            System.out.println("Jenis pembayaran tidak tersedia");
        }
    }   
    // End fitur pembayaran.

    // Fitur Ubah PIN
    static void ubahPIN() {

    }
    // End fitur Ubah PIN

    // Fitur Setor Tunai
    static void setorTunai() {
        long setor;
        int index=1;
        System.out.print("Masukkan nominal yang ingin anda setorkan : ");
        setor = sc.nextLong();
        if (setor > 0) {
            akunUser[0][2] += setor;
            System.out.println("Setor Tunai telah berhasil. Saldo anda saat ini adalah Rp. "+ akunUser[0][2]);
        } else {
            System.out.println("Maaf, setor tunai gagal. Silahkan coba lagi");
        }
    }
    // End fitur Setor Tunai

    // Fitur Transfer
    static void Transfer() {

    }
    // End Fitur Transfer

    // Konfirmasi transaksi pengguna
    static void konfirmasiPembayaran() {
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

    static void updateSaldo(String nama, long newSaldo, long biayaAdmin) {
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


    // static void struk() {
    //     Date tanggalSekarang = new Date();
    //     SimpleDateFormat formatTanggal = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    //     String tanggal = formatTanggal.format(tanggalSekarang);
    //     System.out.println("==========STRUK TRANSAKSI==========");
    //     System.out.println("Tanggal/Waktu   : "+tanggal);
    //     System.out.println("Jenis Transaksi : ");
    //     System.out.println("Sisa saldo      : ");
    //     System.out.println("");
    // }

}
