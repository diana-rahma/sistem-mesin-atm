//Sistem mesin ATM

//import scanner
import java.util.Scanner;
public class jobsheet3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long jumlah_saldo, nominal_transfer, nominal_tarik, sisa_saldo;
        int pin_atm;

        System.out.println("Masukkan jumlah saldo : " );
        jumlah_saldo = sc.nextInt();

        System.out.println("Masukkan jumlah nominal tarik : " );
        nominal_tarik = sc.nextInt();

        sisa_saldo = jumlah_saldo - nominal_tarik;
        System.out.println("Jumlah sisa saldo : " + sisa_saldo);

    }
}