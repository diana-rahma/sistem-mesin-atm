import java.util.Scanner;

public class RegistrasiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah Pendaftar : ");
        int Pendaftar = sc.nextInt();
        sc.nextLine(); 

        String[] namaPend = new String[Pendaftar];

        for (int i = 0; i < Pendaftar; i++) {
            System.out.print("Masukkan Pendaftar ke-" + (i+1) + ": ");
            namaPend[i] = sc.nextLine();
        }

        System.out.print("Masukkan nama Pendaftar yang ingin dicari: ");
        String key = sc.nextLine();

        int hasil = -1;
        for (int i = 0; i < namaPend.length; i++) {
            if (namaPend[i].equals(key)) {
                hasil = i + 1;
                break;
            }
        }
        if (hasil == -1) {
            System.out.println("Pendaftar tidak ditemukan");
        } else {
            System.out.println("Pendaftar ada di nomor " + hasil);
        }
    }
}