import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        Spielbrett spielbrett1 = new Spielbrett();
        Spieler spieler1 = new Spieler();
        Spieler computer = new Computer();
        Spieler spieler2 = new Spieler();



        boolean gameOver = false;
        boolean nochmalSpielen = true;
        Spielbrett.ausgabeSpielbrett(spielbrett1.getSpielBrett());

        //TODO call-by-value & call-by-reference wiederholen
        // Game-Loop + ob nochmal gespielt werden soll
        while (nochmalSpielen == true) {
            while (gameOver == false) { //Game-Loop

                Spieler.spielerZug(spielbrett1.getSpielBrett());
                spielbrett1.setRunden(spielbrett1.getRunden()+1); //!TEST! Spiel nach 8 Runden Unentschieden -> Spielbrett.hatGewonnen: || runden == 8)
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    spieler1.setPunkte(spieler1.getPunkte()+1);
                    System.out.println("Spieler Punkte: " + spieler1.getPunkte());
                    break;
                }

                Computer.computerZug(spielbrett1.getSpielBrett());
                spielbrett1.setRunden(spielbrett1.getRunden()+1);
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    computer.setPunkte(computer.getPunkte()+1);
                    break;
                }
            }

            //System.out.println("Computer Punkte: " + Spielbrett.getComputerPunkte());
            System.out.println("Möchtest du nochmal spielen?  (J / N)");
            //eingabe.nextLine();
            String ergebnis = eingabe.nextLine();

            switch (ergebnis) {
                case "J":
                case "j":
                    nochmalSpielen = true;
                    System.out.println("Ein neues Game startet!");
                    Spielbrett.resetSpielbrett(spielbrett1.getSpielBrett());
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


}