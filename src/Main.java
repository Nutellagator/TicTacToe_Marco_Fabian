import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        Spielbrett spielbrett1 = new Spielbrett();
        Spieler spieler1 = new Spieler();

        boolean gameOver = false;
        boolean nochmalSpielen = true;
        Spielbrett.ausgabeSpielbrett(spielbrett1.getSpielBrett());

        //TODO call-by-value & call-by-reference wiederholen
        // Game-Loop + ob nochmal gespielt werden soll
        while (nochmalSpielen == true) {
            while (gameOver == false) { //Game-Loop

                Spieler.spielerZug(spielbrett1.getSpielBrett());
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    break;
                }

                Computer.computerZug(spielbrett1.getSpielBrett());
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    break;
                }
            }
            System.out.println("Spieler Punkte: " + Spielbrett.getSpielerPunkte());
            System.out.println("Computer Punkte: " + Spielbrett.getComputerPunkte());
            System.out.println("Möchtest du nochmal spielen?  (J / N)");
            //eingabe.nextLine();
            String ergebnis = eingabe.nextLine();

            switch (ergebnis) {
                case "J":
                case "j":
                    nochmalSpielen = true;
                    System.out.println("Ein neues Game startet!");
                    resetSpielbrett(spielbrett1.getSpielBrett());
                    gameOver = false;
                    Spielbrett.ausgabeSpielbrett(spielbrett1.getSpielBrett());
                    break;

                case "N":
                case "n":
                    nochmalSpielen = false;
                    System.out.println("Bis zum nächsten mal!");
                    break;
                default:
                    break;
            }

        }
    }

// TODO: UpdateTest erfolgreich
//        updateSpielbrett(2,1,spielBrett);
//        updateSpielbrett(3,1,spielBrett);
//        updateSpielbrett(4,2,spielBrett);
//        updateSpielbrett(5,2,spielBrett);
//        updateSpielbrett(6,2,spielBrett);

// TODO: Wie greifen die Methoden auf die Werte einer anderen Methode zu

        /*spielerZug(spielBrett);
        computerZug(spielBrett);
        spielerZug(spielBrett);
        computerZug(spielBrett);*/



    // Wenn nochmal gespielt werden soll, dann wird Spielfeld (Arrays) zurückgesetzt
    public static void resetSpielbrett(char[][] spielBrett) {
        spielBrett[0][0] = '_';
        spielBrett[0][2] = '_';
        spielBrett[0][4] = '_';
        spielBrett[1][0] = '_';
        spielBrett[1][2] = '_';
        spielBrett[1][4] = '_';
        spielBrett[2][0] = ' ';
        spielBrett[2][2] = ' ';
        spielBrett[2][4] = ' ';

    }
}