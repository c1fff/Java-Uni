//Rauan Dauletbek, 12337766
package einfprog;

public class Bsp04 {
    public static void main(String[] args) {
        // TODO: implement this.
        createPassword();
    }


    // ============================= PART 1 =============================
    // Prompt the user for a password.
    public static String createPassword() {
        String pass;
        String cpass;
        System.out.println("Passwort eingeben / stop für Abbruch: ");
        pass = SavitchIn.readLineWord();
        if (pass.equals("stop")) {
            System.out.println("Eingabe abgebrochen!");
            return "";
        }
        System.out.println("Passwort wiederholen: ");
        cpass = SavitchIn.readLineWord();
        if (cpass.equals("stop")) {
            System.out.println("Eingabe abgebrochen!");
            return "";
        }
        if (pass.equals(cpass) != true) {
            while(pass.equals(cpass) != true){
                System.out.println("Passwort eingeben / stop für Abbruch: ");
                pass = SavitchIn.readLineWord();
                if (pass.equals("stop")) {
                    System.out.println("Eingabe abgebrochen!");
                    return "";
                }

                System.out.println("Passwort wiederholen: ");
                cpass = SavitchIn.readLineWord();
                if (cpass.equals("stop")) {
                    System.out.println("Eingabe abgebrochen!");
                    return "";
                }
            }

            if (minLength(cpass, 8) == false) {
                System.out.println("Passwort zu kurz!");
            }
            if (fitFirstCharacter(cpass) == false) {
                System.out.println("Erstes Zeichen kein Buchstabe!");
            }
            if (minUpperCase(cpass, 2) == false){
                System.out.println("Zu wenige Grossbuchstaben!");
            }
            if (minLowerCase(cpass, 2) == false){
                System.out.println("Zu wenige Kleinbuchstaben!");
            }
            if (minDigit(cpass, 2) == false){
                System.out.println("Zu wenige Ziffern!");
            }
            if (minSpecial(cpass, 1) == false){
                System.out.println("Zu wenige Sonderzeichen!");
            }
            if (isolatedSpecial(cpass) == false){
                System.out.println("Sonderzeichen nebeneinander!");
            }
            if (minLength(cpass, 8) && fitFirstCharacter(cpass) && minUpperCase(cpass, 2) && minLowerCase(cpass, 2) && minDigit(cpass, 2) && minSpecial(cpass, 1) && isolatedSpecial(cpass)){
                System.out.println("Passwort gültig.");
            }
            return cpass;
        }
        else{
            if (minLength(cpass, 8) == false) {
                System.out.println("Passwort zu kurz!");
            }
            if (fitFirstCharacter(cpass) == false) {
                System.out.println("Erstes Zeichen kein Buchstabe!");
            }
            if (minUpperCase(cpass, 2) == false){
                System.out.println("Zu wenige Grossbuchstaben!");
            }
            if (minLowerCase(cpass, 2) == false){
                System.out.println("Zu wenige Kleinbuchstaben!");
            }
            if (minDigit(cpass, 2) == false){
                System.out.println("Zu wenige Ziffern!");
            }
            if (minSpecial(cpass, 1) == false){
                System.out.println("Zu wenige Sonderzeichen!");
            }
            if (isolatedSpecial(cpass) == false){
                System.out.println("Sonderzeichen nebeneinander!");
            }
            if (minLength(cpass, 8) && minLength(pass, 8) && fitFirstCharacter(cpass) && fitFirstCharacter(pass) && minUpperCase(cpass, 2) && minUpperCase(pass, 2) && minLowerCase(pass, 2) && minLowerCase(cpass, 2) && minDigit(cpass, 2) & minDigit(pass, 2) && minSpecial(cpass, 1) && minSpecial(pass, 1) && isolatedSpecial(cpass) && isolatedSpecial(pass)){
                System.out.println("Passwort gültig.");
            }
            return cpass;
        }
    }

    // Check whether `pwd` contains at least `min` characters.
    public static boolean minLength (String pwd, int min) {
        if(pwd.length() >= min){
            return true;
        }else {
            return false;
        }    // TODO: implement this.
    }

    // Check whether the first character of `pwd` is a letter.
    public static boolean fitFirstCharacter (String pwd) {
        if(Character.isLetter(pwd.charAt(0))){
            return true;
        }else {
            return false;
        }                  // TODO: implement this.
    }


    // ============================= PART 2 =============================
    // Check whether `pwd` contains at least `min` uppercase characters.
    public static boolean minUpperCase (String pwd, int min) {
        int uppercaseCount = 0;

        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isUpperCase(pwd.charAt(i))) {
                uppercaseCount++;
            }

        }
        if (uppercaseCount >= min) {
            return true;
        }
        else{
            return false;
        }
    }

    // Check whether `pwd` contains at least `min` lowercase characters.
    public static boolean minLowerCase (String pwd, int min) {
        int lowercaseCount = 0;

        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isLowerCase(pwd.charAt(i))) {
                lowercaseCount++;
            }
        }
        if (lowercaseCount >= min) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check whether `pwd` contains at least `min` digits.
    public static boolean minDigit (String pwd, int min) {
        int digitCount = 0;

        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isDigit(pwd.charAt(i))) {
                digitCount++;
            }
        }
        if (digitCount >= min) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check whether `pwd` contains at least `min` of any of the following
    // characters (in any combination):
    //
    //    ! " # % & ' ( ) * + , - . / @
    //
    public static boolean minSpecial (String pwd, int min) {
        int specialCount = 0;
        String spec = "!\"#%&'()*+,\\-./@" ;

        for (int i = 0; i < pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (spec.indexOf(c) != -1){
                specialCount++;
            }
        }
        if (specialCount >= min) {
            return true;
        }
        else {
            return false;
        }
    }

    // Check whether `pwd` contains only isolated special characters.
    public static boolean isolatedSpecial (String pwd) {
        int specialCount = 0;

        for (int i = 0; i < pwd.length(); i++) {
            char currentChar = pwd.charAt(i);
            if (!Character.isLetterOrDigit(currentChar) && !Character.isWhitespace(currentChar)) {
                specialCount++;
                if (specialCount >= 2) {
                    char prevChar = pwd.charAt(i - 1);
                    if (!Character.isLetterOrDigit(prevChar) && !Character.isWhitespace(prevChar)) {
                        return false;
                    }
                }
            }
            else {
                specialCount = 0;
            }
        }
        return true;
    }
}