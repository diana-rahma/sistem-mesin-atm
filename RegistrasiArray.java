import java.util.Scanner;

public class RegistrasiArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int anggota = 5;
        
        String[][] identitas = new String[anggota][4];
        
        int jumlah = 0; 
        
        while (true) {
            if (jumlah >= anggota) {
                System.out.println("Kapasitas anggota penuh. Tidak bisa mendaftar lagi.");
                break;
            }
            
            System.out.println("Registrasi anggota ke-" + (jumlah + 1));
            System.out.print("Nama: ");
            String nama = input.nextLine();
            
            System.out.print("No. HP: ");
            String nohp = input.nextLine();
            
            System.out.print("Asal: ");
            String asal = input.nextLine();
            
            System.out.print("PIN: ");
            String pin = input.nextLine();
            
            identitas[jumlah][0] = nama;
            identitas[jumlah][1] = nohp;
            identitas[jumlah][2] = asal;
            identitas[jumlah][3] = pin;
            
            jumlah++; 
            
            System.out.print("Apakah Anda ingin mendaftar anggota lain? (y/n): ");
            String lagi = input.nextLine();
            if (lagi.equalsIgnoreCase("n")) {
                break;
            }
        }
        
        System.out.println("Daftar anggota yang Terdaftar:");
        for (int i = 0; i < jumlah; i++) {
            System.out.println("anggota ke-" + (i + 1));
            System.out.println("Nama: " + identitas[i][0]);
            System.out.println("No. HP: " + identitas[i][1]);
            System.out.println("Asal: " + identitas[i][2]);
            System.out.println("PIN: " + identitas[i][3]);
            System.out.println();
        }      
    }
}
