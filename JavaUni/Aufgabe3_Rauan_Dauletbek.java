//Rauan Dauletbek, 12337766
package einfprog;

public class Bsp03 {
    public static void main(String[] args) {
        // TODO: Test your solution here.

        System.out.println("? Maximale Anzahl der Wuerfe: ");
        int adw = SavitchIn.readLineInt();
        int a1 =0, a2 = 0, a3 = 0;

        for(int i = 0; i<adw; i++){
            int c1 = rollDie();
            int c2 = rollDie();
            if (hasSingleOne(c1, c2)) {
                a1 ++;
                System.out.println("(" + c1 + "," + c2 + ") Einfache 1 (keine Punkte) #" +a1);
            } else if (hasDoubleOne(c1, c2)) {
                a2 ++;
                System.out.println("(" + c1 + "," + c2 + ") Doppelte 1 (Ruecksetzung) #"+a2);
            }
            else{
                a3 ++;
                System.out.println("(" + c1 + "," + c2 + ") Punkte #"+a3);
            }
        }
        System.out.println("? Anzahl der Spieler:innen: ");
        int spiel = SavitchIn.readLineInt();
        pig(spiel);

    }
    // PART 1
    // Computes a random number between 1 and 6. 
    public static int rollDie() {
        PRNG prng = new PRNG();
        return prng.randomInt(6)+1;
    }

    // Returns whether exactly one of d1 or d2 (but not both!) is equal to 1.
    public static boolean hasSingleOne(int d1, int d2) {
        if((d1 == 1 && d2 != 1) || (d1 != 1 && d2 == 1)) {
            return true;
        }
        else {
            return false; // TODO: implement this.
        }
    }

    // Returns whether both d1 and d2 are each equal to 1.
    public static boolean hasDoubleOne(int d1, int d2) {
        if(d1 == 1 && d2 == 1) {
            return true; // TODO: implement this.
        }
        else{
            return false;
        }
    }

    // PART 2
    // Simulate the game Pig for `n` players; note that
    // `n` is always >= 1.
        public static int pig(int n) {
        int maxSum = 0;
        int winner = 0;
        int wurfwinner = 0;
        for (int i = 1; i < n + 1; i++) {
            int wurf = 1;
            int sum = 0;
            System.out.println("##### Spieler:in " + i);
            int d1 = rollDie();
            int d2 = rollDie();
            while (hasSingleOne(d1, d2) == false || hasDoubleOne(d1, d2) == false){
                if (hasSingleOne(d1, d2) == true) {
                    System.out.println(wurf + ".Wurf: (" +  d1 + "," + d2 + ") | " + sum);
                    break;

                }
                else if (hasDoubleOne(d1, d2) == true) {
                    System.out.println(wurf + ".Wurf: (" +  d1 + "," + d2 + ") | " + (sum=0));
                    break;
                }
                else {
                    sum = sum + d1 + d2;
                    System.out.println(wurf + ".Wurf: (" +  d1 + "," + d2 + ") | " + sum);
                    wurf++;
                    d1 = rollDie();
                    d2 = rollDie();
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                winner = i;
            }
            if (wurf > wurfwinner) {
                wurfwinner = wurf;
            }
        }
        System.out.println("##### Gewinner:in: Spieler:in " + winner);
        System.out.println("##### Anzahl der Wuerfe: " + wurfwinner);
        System.out.println("##### Maximale Punktezahl: " + maxSum);
        return maxSum;
    }
}