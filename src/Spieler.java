import java.util.Scanner;

public class Spieler {
    static Scanner eingabe = new Scanner(System.in);

    //wo der jeweilige Spieler sein Zeichen (X oder O) setzen möchte
    public static void spielerZug(char[][] spielBrett) {

        System.out.println("Nächsten Zug eingeben (1-9)");

        int spielZug = eingabe.nextInt();

        boolean ergebnis = istSpielzugErlaubt(spielZug, spielBrett);

        while (ergebnis == false) {  //TODO Kurzschreibweise wiederholen/lernen
            System.out.println("Feld wurde bereits gewählt");
            spielZug = eingabe.nextInt();
            ergebnis = istSpielzugErlaubt(spielZug, spielBrett);
        }

        System.out.println("Position " + spielZug + " gewählt.");
        Spielbrett.updateSpielbrett(spielZug, 1, spielBrett);

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
