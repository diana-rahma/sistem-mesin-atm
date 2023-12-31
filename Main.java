import java.util.Scanner;
import java.util.Arrays;

public class Main {
    // static String[][] akunUser = {
    // { "Diana", "12345678", "150000000" },
    // { "Varizky", "87654321", "200000000" },
    // { "Romy", "12341234", "100000000" }
    // };
    static Scanner sc = new Scanner(System.in);
    static String[] namaUser = { "Diana", "Varizky", "Romy" };
    static int[] pinUser = { 1234, 6543, 1122 };
    static long[] saldo = { 1000000, 2000000, 3000000 };
    static String konfirmasi, Struk, Menu, sedangLogin, ulangMenu, jenisBayar;
    static long jmlSaldo = 150000000, Nominal, jumlahBayar, tagihan;
    static boolean selesaiTransaksi = false, lanjutTransaksi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pilihan, kodeBank, bankTujuan;
        long sisa, nominalTransfer;
        String Nama, Asal, Profesi, Past, New, New2;

        System.out.println("*********************************************");
        System.out.println("*             SISTEM MESIN ATM              *");
        System.out.println("*********************************************");

        // Apakah pengguna memiliki akun atau tidak
        System.out.println("Semua Pilihan hanya menggunakan angka !");
        System.out.println("Apakah anda memiliki akun? ");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        String konfirmasi = sc.next();

        if (konfirmasi.equals("1")) {
            boolean loginBerhasil = false;
            do {
                loginBerhasil = login();
            } while (!loginBerhasil);

            do {
                    switch (tampilanMenu()) {
    
                    // Tarik Tunai
                    case "1":
                        tarikTunai();
                        opsiMenu();
                        break;
    
                    // Informasi Saldo
                    case "2":
                        informasiSaldo();
                        opsiMenu();
                        break;
    
                    // Pembayaran
                    case "3":
                        pembayaran();
                        opsiMenu();
                        break;
    
                    // Ubah PIN
                    case "4":
                        ubahPIN();
                        opsiMenu();
                        break;
    
                    // Setor Tunai
                    case "5":
                        setorTunai();
                        opsiMenu();
                        break;
    
                    // Transfer
                    case "6":
                        transfer();
                        opsiMenu();  
                        break;
    
                    case "0":
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Menu tidak tersedia ");
                }
            } while(lanjutTransaksi);
        } else if (konfirmasi.equals("2")) {
            System.out.println("\nAnda Belum punya akun?");
            System.out.println("Silahkan Registrasi terlebih dahulu ");
            System.out.print("\nMasukkan Nama Anda : ");
            Nama = sc.next();

            System.out.print("Masukkan Asal Anda : ");
            Asal = sc.next();

            System.out.print("Masukkan Profesi Anda : ");
            Profesi = sc.next();

            registrasi(Nama, Asal, Profesi);
        } else {
            System.out.println(" invalid Input ");
        }
    }

    // FUNGSI FUNGSI AN

    // Login User
    static boolean login() {
        System.out.print("Masukkan nama : ");
        String nama = sc.next();
        System.out.print("Masukkan PIN  : ");
        String pin = sc.next();
        boolean status = cek(nama);
        if (status) {
            System.out.println("Login berhasil! Selamat datang, " + nama + "!");
            sedangLogin = nama;
            return true;
        } else {
            System.out.println("Login gagal. Nama atau PIN  salah.");
            return false;
        }
    }

    static boolean cek(String nama) {
        for (int i = 0; i < namaUser.length; i++) {
            if (namaUser[i].equals(nama)) {
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

            if (now.equalsIgnoreCase(now2)) {
                break;
            } else {
                System.out.println("Pin tidak sama");
            }
        } while (now != now2);

        System.out.println("Selamat! Akun Anda telah terdaftar");
        System.out.println("Nama = " + Nama);
        System.out.println("Asal = " + Asal);
        System.out.println("Profesi = " + Profesi);
    }
    // End Registrasi User

    // Menu
    static String tampilanMenu() {
        System.out.println("\n");
        System.out.println("*********************************");
        System.out.println("*             MENU              *");
        System.out.println("*********************************");
        System.out.println("\t * 1. Tarik Tunai ");
        System.out.println("\t * 2. Informasi Saldo ");
        System.out.println("\t * 3. Pembayaran ");
        System.out.println("\t * 4. Ubah PIN ");
        System.out.println("\t * 5. Setor Tunai ");
        System.out.println("\t * 6. Transfer ");
        System.out.println("\t * 0. Keluar ");
        System.out.println("Silahkan Pilih salah satu menu di atas! ");
        sc.nextLine();
        Menu = sc.nextLine();
        return Menu;
    }
    // End Menu

    // mengulang menu transaksi
    static void opsiMenu() {
        System.out.println("Apakah anda ingin melakukan transaksi lain?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        ulangMenu = sc.next();

        if (ulangMenu.equals("1")) {
            lanjutTransaksi = true;
        } else {
            lanjutTransaksi = false;
        } 
    }
    // end mengulang menu transaksi

    // Fungsi untuk mencari indeks akun berdasarkan nama pengguna
    static int identifikasiUser(String nama) {
        for (int i = 0; i < namaUser.length; i++) {
            if (namaUser[i].equals(nama)) {
                return i;
            }
        }
        return -1;
    }
    // selesai Pengecekan

    // Fitur Tarik Tunai
    static void tarikTunai() {

        int index = identifikasiUser(sedangLogin);

        if (index != -1) {

            System.out.println("Masukkan Nominal yang ingin Anda tarik ");
            Nominal = sc.nextLong();
            // Periksa saldo sebelum melakukan penarikan
            long saldoAkun = saldo[index];

            if (Nominal <= saldoAkun) {

                long biayaAdmin = (Nominal >= 500000) ? 5000 : 0;

                saldo[index] -= (Nominal + biayaAdmin);

                System.out.println("Penarikan tunai berhasil.");

                cetakStruk(Nominal, saldo[index]);
            } else {
                System.out.println("Saldo tidak mencukupi untuk penarikan tersebut.");
            }
        } else {
            System.out.println("Akun tidak ditemukan.");
        }
    }
    // End Fitur Tarik Tunai

    // Fitur Informasi Saldo
    static void informasiSaldo() {
        int index = identifikasiUser(sedangLogin);
        if (index != -1) {
            System.out.println("Informasi Saldo");
            System.out.println("Nama: " + namaUser[index]);
            System.out.println("Saldo: Rp" + saldo[index]);
        } else {
            System.out.println("Akun tidak ditemukan.");
        }
    }
    // End Fitur Informasi Saldo

    // Fitur Pembayaran
    static void pembayaran() {
        int index = identifikasiUser(sedangLogin);
        int kodeBayar, noCust;
        long setor = saldo[index];
        if (index != -1) {
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
                    saldo[index] -= jumlahBayar;
                    konfirmasiPembayaran();
                    break;

                case "2":
                    System.out.println("-----Bayar Tagihan Air PDAM----");
                    System.out.print("Masukkan kode PDAM : ");
                    kodeBayar = sc.nextInt();
                    System.out.print("Masukkan kode pelanggan : ");
                    noCust = sc.nextInt();
                    System.out.print("Masukkan jumlah tagihan yang akan dibayar : ");
                    jumlahBayar = sc.nextLong();
                    saldo[index] -= jumlahBayar;
                    konfirmasiPembayaran();
                    break;

                case "3":
                    System.out.println("-----Bayar Pajak-----");
                    System.out.print("Masukkan kode tagihan : ");
                    kodeBayar = sc.nextInt();
                    System.out.print("Masukkan jumlah tagihan pajak : ");
                    jumlahBayar = sc.nextLong();
                    saldo[index] -= jumlahBayar;
                    konfirmasiPembayaran();
                    break;

                case "4":
                    System.out.println("-----Bayar Online Shop-----");
                    System.out.print("Masukkan kode bayar : ");
                    kodeBayar = sc.nextInt();
                    System.out.print("Masukkan nominal pembayaran yang harus dibayar : ");
                    jumlahBayar = sc.nextLong();
                    saldo[index] -= jumlahBayar;
                    konfirmasiPembayaran();
                    break;
                default:
                    System.out.println("Jenis pembayaran tidak tersedia");
            }
        }
    }
    // End fitur pembayaran.

    // Fitur Ubah PIN
    static void ubahPIN() {
        Scanner sc = new Scanner(System.in);
        int index = identifikasiUser(sedangLogin);

        if (index != -1) {
            System.out.println("Masukkan PIN lama anda: ");
            int oldPIN = sc.nextInt();

            if (pinUser[index] == oldPIN) {
                System.out.println("Masukkan PIN baru: ");
                int New = sc.nextInt();

                System.out.println("Konfirmasi PIN baru: ");
                int New2 = sc.nextInt();

                if (New == New2) {
                    pinUser[index] = New;
                    System.out.println("PIN berhasil diubah.");
                    System.out.println("PIN anda sekarang adalah : " + New);
                } else {
                    System.out.println("PIN baru tidak sesuai dengan konfirmasi. Silakan coba lagi.");
                }
            } else {
                System.out.println("PIN lama salah. Coba lagi.");
            }
        } else {
            System.out.println("Anda Belum Login");
        }

    }
    // End Fitur Ubah PIN

    // Fitur Setor Tunai
    static void setorTunai() {
        int index = identifikasiUser(sedangLogin);
        if (index != -1) {
            System.out.print("Masukkan nominal yang ingin anda setorkan : ");
            Nominal = sc.nextLong();
            long setor = saldo[index];
            if (Nominal > 0) {
                saldo[index] += Nominal;
                System.out.println("Setor tunai senilai Rp" + Nominal + " berhasil");
                System.out.println("==========STRUK TRANSAKSI SETOR TUNAI==========");
                System.out.println("Nominal transaksi : Rp" + Nominal);
                System.out.println("Sisa saldo anda   : Rp" + saldo[index]);
                System.out.println("Terima kasih telah melakukan transaksi");
                System.out.println("===============================================");
            } else {
                System.out.println("Tarik tunai gagal.");
            }
        } 
    }
    // End fitur Setor Tunai

    // Fitur Transfer
    static void transfer() {
        int indexPengirim = identifikasiUser(sedangLogin);

        if (indexPengirim != -1) {
            System.out.println("Masukkan nama penerima: ");
            String namaPenerima = sc.next();

            int indexPenerima = identifikasiUser(namaPenerima);

            if (indexPenerima != -1) {
                System.out.println("Masukkan nominal yang ingin Anda transfer: ");
                Nominal = sc.nextLong();

                // Biaya admin
                System.out.println("Apakah Anda mentransfer ke bank yang sama?");
                System.out.println("1. Ya");
                System.out.println("2. Tidak");
                int transferSameBank = sc.nextInt();

                if (transferSameBank == 2) {
                    System.out.println("Biaya admin: Rp20000");
                    Nominal += 20000;
                } else {
                    if (Nominal < 500000) {
                        System.out.println("Biaya admin: Rp10000");
                        Nominal += 10000;
                    } else {
                        System.out.println("Biaya admin: Gratis");
                    }
                }

                // Cek apakah saldo cukup
                if (Nominal <= saldo[indexPengirim]) {
                    saldo[indexPengirim] -= Nominal;

                    System.out.println("Transfer berhasil.");
                    System.out.println("Jumlah transfer: Rp" + Nominal);
                    System.out.println("Sisa saldo Anda: Rp" + saldo[indexPengirim]);
                } else {
                    System.out.println("Saldo tidak mencukupi untuk transfer tersebut.");
                }
            } else {
                System.out.println("Penerima tidak ditemukan.");
            }
        }
    }
    // End Fitur Transfer

    // Konfirmasi pembayaran pengguna
    static void konfirmasiPembayaran() {
        int index = identifikasiUser(sedangLogin);
        System.out.println("Apakah anda yakin untuk melakukan pembayaran?");
        System.out.println("1. Iya");
        System.out.println("2. Tidak");
        String data = sc.next();
        if (data.equals("1")) {
            System.out.println("Pembayaran akan diproses");
            System.out.println("==========STRUK TRANSAKSI PEMBAYARAN==========");
            System.out.println("Nominal transaksi : Rp" + jumlahBayar);
            System.out.println("Sisa saldo anda   : Rp" + saldo[index]);
            System.out.println("Terima kasih telah melakukan transaksi");
            System.out.println("==============================================");
        } else {
            System.out.println("Pembayaran dibatalkan.");
            opsiMenu();
        }
    }
    // End konfirmasi pembayaran pengguna

    // Struk tarik tunai
    static void cetakStruk(long Nominal, long hasil) {
        System.out.println("===== STRUK TRANSAKSI =====");
        System.out.println("Nominal Transaksi: Rp " + Nominal);
        System.out.println("Sisa Saldo: Rp " + hasil);
        System.out.println("Terima kasih telah melakukan transaksi!");
    }
    // End Struk
}
