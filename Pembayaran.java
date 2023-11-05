import java.util.Scanner;
public class Pembayaran {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int kodeBayar, kodeInstitusi, noRek;
        long jumlahBayar, tagihan;
        String struk, jenisBayar, data, konfirmasi, jenisRek;

        System.out.println("Silahkan pilih jenis pembayaran / pembelian");
        System.out.println("(Angsuran) (Asuransi) (Pajak) (Kartu Kredit)");

        jenisBayar = input.nextLine();
        switch (jenisBayar) {
            case "Angsuran":
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
            
            case "Asuransi":
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
            
            case "Pajak":
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
                // System.out.println("Pilih jenis rekening : Rekening Tabungan/Rekening Giro ");
                // jenisRek = input.next();
                // if (jenisRek.equals("Rekening Tabungan")) {
                //     System.out.println("Konfirmasi pembayaran dengan tabungan rekening. y/t");
                //     konfirmasi = input.next();
                //     if (konfirmasi.equals("y")) {
                //         System.out.println("Pembayaran akan diproses");
                //     } else {
                //         System.out.println("Silahkan kembali ke menu");
                //     }
                // } else if (jenisRek.equals("Rekening Giro")) {
                //      System.out.print("Konfirmasi Pembayaran dengan tabungan giro. y/t");
                //     konfirmasi = input.next();
                //     if (konfirmasi.equals("y")) {
                //         System.out.println("Pembayaran akan diproses");
                //     } else {
                //         System.out.println("Silahkan kembali ke menu");
                //     }
                // }
                break;

            case "Kartu Kredit":
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
                break;
        }
    }
}
