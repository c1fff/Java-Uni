// Rauan Dauletbek, 12337766
package einfprog;
import java.util.Scanner;

public class Bsp01 {
    public static void main(String[] args) {
        // TODO: implement.
        System.out.println();
        System.out.println("? Monat: ");
        int month = SavitchIn.readLineInt();
        
        System.out.println();
        System.out.print("? Tag: ");
        int day = SavitchIn.readLineInt();
        
        if(month == 10 && day == 29 || month == 3 && day == 26){
            System.out.println("Schalttag");
        } else if(month <= 3 && day < 26 || month >= 10 && day > 29 || month > 10 || month < 3){
            System.out.println("Winterzeit");
        } else if(month >= 3 && day > 26 || month >=3){
            System.out.println("Sommerzeit");
        }
    }
}