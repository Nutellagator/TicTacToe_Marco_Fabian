import java.util.Random;
import java.util.Scanner;

public class Gameloop {
    static Scanner eingabe = new Scanner(System.in);

    public void startGame(Spieler spieler1, Spieler spieler2){ // Spieler außerhalb von Gameloop generiert (von außen definiert, um zu sagen ob Spieler oder Computer)
        Spielbrett spielbrett1 = new Spielbrett();

        boolean gameOver = false;
        boolean nochmalSpielen = true;
        Spielbrett.ausgabeSpielbrett(spielbrett1.getSpielBrett());

        //TODO call-by-value & call-by-reference wiederholen
        // Game-Loop + ob nochmal gespielt werden soll
        while (nochmalSpielen == true) {
            while (gameOver == false) { //Game-Loop

                spielerZug(spielbrett1.getSpielBrett(), spieler1);
                //spielbrett1.setRunden(spielbrett1.getRunden()+1); //!TEST! Spiel nach 8 Runden Unentschieden -> Spielbrett.hatGewonnen: || runden == 8)
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    spieler1.setPunkte(spieler1.getPunkte()+1);
                    System.out.println("Spieler 1 Punkte: " + spieler1.getPunkte());
                    break;
                }

                spielerZug(spielbrett1.getSpielBrett(), spieler2);
                //spielbrett1.setRunden(spielbrett1.getRunden()+1);
                gameOver = Spielbrett.hatGewonnen(spielbrett1.getSpielBrett());
                if (gameOver == true) {
                    spieler2.setPunkte(spieler2.getPunkte()+1);
                    System.out.println("Spieler 2 Punkte: " + spieler2.getPunkte());
                    break;
                }
            }

            //System.out.println("Computer Punkte: " + Spielbrett.getComputerPunkte());
            System.out.println("Möchtest du nochmal spielen?  (J / N)");
            //eingabe.nextLine();
            String istSpielzugErlaubt = eingabe.nextLine();

            switch (istSpielzugErlaubt) {
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
                    System.out.println("Eingabe nicht möglich, Spiel wird beendet"); //
                    nochmalSpielen = false;
                    break;
            }

        }
    }

    //wo der jeweilige Spieler sein Zeichen (X oder O) setzen möchte
    public static void spielerZug(char[][] spielBrett, Spieler spieler) { //weil spielbrett statisch ist, kann man es im Spieler nicht schreiben

        int spielZug;
        if(spieler instanceof Computer) {   // instanceoff = Prüft ob Spieler spieler ein computer ist TODO bei vererbung!
                                            // (Computer ist immer ein Spieler, aber spieler ist nicht immer ein computer)
                                            // Wenn der Spieler ein Computer ist, gib True zurück -> ist spieler ein computer?
                                            // (Tier -> welches Tier?
            Random rand = new Random();

            boolean istSpielzugErlaubt; // TODO BESSER: istSpielzugErlaubt

            do {
                spielZug = rand.nextInt(9) + 1;
                istSpielzugErlaubt = Gameloop.istSpielzugErlaubt(spielZug, spielBrett);
            } while (istSpielzugErlaubt == false);

            System.out.println("Computer Spielzug: " + spielZug);
        } else {

            System.out.println("Nächsten Zug eingeben (1-9)");
            Scanner eingabe = new Scanner(System.in);
            spielZug = eingabe.nextInt();

            boolean istSpielzugErlaubt = istSpielzugErlaubt(spielZug, spielBrett);

            while (istSpielzugErlaubt == false) {  //TODO Kurzschreibweise wiederholen/lernen
                System.out.println("Feld wurde bereits gewählt");
                spielZug = eingabe.nextInt();
                istSpielzugErlaubt = istSpielzugErlaubt(spielZug, spielBrett);
            }

            System.out.println("Position " + spielZug + " gewählt.");
        }
        Spielbrett.updateSpielbrett(spielZug, spieler.getSpielerNummer(), spielBrett);

    }

    //Ist das jeweilige Feld noch bespielbar
    public static boolean istSpielzugErlaubt(int spielZug, char[][] spielBrett) {

        switch (spielZug) {
            case 1:
                if (spielBrett[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (spielBrett[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (spielBrett[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (spielBrett[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (spielBrett[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (spielBrett[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (spielBrett[2][0] == ' ') {        // Letztes Array leerzeichen wegen Augenschmaus
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (spielBrett[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (spielBrett[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }

    }



}

