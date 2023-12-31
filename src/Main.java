import java.util.Scanner;

public class Main {
    //TODO Ausgabe anpassen das Computer gewinnt
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        ScannerCheck intCheck = new ScannerCheck();

        System.out.println("Bitte Zahl zwischen 1-3 eingeben:");
        System.out.println("");
        System.out.println("1: Spieler gegen Computer");
        System.out.println("2: Spieler gegen Spieler");
        System.out.println("3: Computer gegen Computer");

        int eingabe = intCheck.getInputInt();
        while (eingabe != 1 && eingabe != 2 && eingabe != 3) { // TODO Es darf auch kein Text eingegeben werden
            System.out.println("Bitte Zahl zwischen 1-3 eingeben:");
            System.out.println("");
            System.out.println("1: Spieler gegen Computer");
            System.out.println("2: Spieler gegen Spieler");
            System.out.println("3: Computer gegen Computer");
            eingabe = intCheck.getInputInt();
        }

        Spieler spieler1 = null;    // Spieler als leeres Feld initialisiert (Platzhalter)
        Spieler spieler2 = null;

        if (eingabe == 1) {
            spieler1 = new Spieler(1);
            spieler2 = new Computer(2); //instanceof
        } else if (eingabe == 2) {
            spieler1 = new Spieler(1);
            spieler2 = new Spieler(2);
        } else {
            spieler1 = new Computer(1);
            spieler2 = new Computer(2);
        }


        if (spielerFolgeUmdrehen() == true) {
            System.out.println("(Zufall) Spieler 1 beginnt! ");
            Gameloop g1 = new Gameloop();
            g1.startGame(spieler1, spieler2);
        } else {
            System.out.println("(Zufall) Spieler 2 beginnt! ");
            Gameloop g2 = new Gameloop();
            g2.startGame(spieler2, spieler1);
        }

    }

    public static boolean spielerFolgeUmdrehen() { // werBeginnt
        double randomnumber = Math.random();
        if (randomnumber <= 0.5) {
            return true;
        } else {
            return false;
        }
    }

}