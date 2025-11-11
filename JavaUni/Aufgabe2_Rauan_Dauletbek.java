// Rauan Dauletbek, 12337766
package einfprog;

public class Bsp02 {
    public static void main(String[] args) {
        
        // TODO: Implement.
        //Mehl (in g): 200
        //Zucker (in g): 100
        //Eier (Stück): 2
        int m = 200, z = 100, e = 2;
        
        System.out.println("? Mehl: ");
        int mehl = SavitchIn.readLineInt();
        
        System.out.println("? Zucker: ");
        int zucker = SavitchIn.readLineInt();
        
        System.out.println("? Eier: ");
        int eier = SavitchIn.readLineInt();
        
        if(mehl >= m && zucker >= z && eier >= e){
            int mehl1 = mehl / m;
            int zucker1 = zucker / z;
            int eee = eier / e;
            int anzkuch = 0;
            if(mehl1 <= zucker1 && mehl1 <= eee){
                anzkuch += mehl1;
                mehl -= anzkuch * 200;
                zucker -= anzkuch * 100;
                eier -= anzkuch * 2;
                System.out.println("Anzahl der Kuchen: " + anzkuch);
                System.out.println("Rest: " + mehl+"g Mehl, " +zucker+"g Zucker, " + eier + " Ei(er)");
            } else if (zucker1 <= mehl1 && zucker1<= eee) {
                anzkuch += zucker1;
                mehl -= anzkuch * 200;
                zucker -= anzkuch * 100;
                eier -= anzkuch * 2;
                System.out.println("Anzahl der Kuchen: " + anzkuch);
                System.out.println("Rest: " + mehl+"g Mehl, " +zucker+"g Zucker, " + eier + " Ei(er)");
            }else{
                anzkuch = eee;
                mehl -= anzkuch * 200;
                zucker -= anzkuch * 100;
                eier -= anzkuch * 2;
                System.out.println("Anzahl der Kuchen: " + anzkuch);
                System.out.println("Rest: " + mehl+"g Mehl, " +zucker+"g Zucker, " + eier + " Ei(er)");
            }
        }else{
            System.out.println("Anzahl der Kuchen: 0");
            System.out.println("Rest: " + mehl+"g Mehl, " +zucker+"g Zucker, " + eier + " Ei(er)");
        }
        
        System.out.println("? Kosten: ");
        double k = SavitchIn.readLineDouble();
        
        System.out.println("? Anzahl der Abnehmer: ");
        double a = SavitchIn.readLineDouble();
        
        double gs = 0;

        for(int i = 0; i < a; i++){
           System.out.println("? Spende: ");
           double spende = SavitchIn.readLineDouble();
           gs += spende;
           if (gs >= k) {
                System.out.println("--- Gewinnzone ---");
                for(int j = i+1; j < a; j ++){
                    System.out.println("? Spende: ");
                    spende = SavitchIn.readLineDouble();
                    gs += spende;
                }
           break;
           }
        }
        if(gs>=k){
            System.out.println("Gesamtspenden: " + gs);
        }else{
            System.out.println("Gesamtspenden: "+ gs);
            System.out.println("Verlust");
        }
    }
}