import java.util.Random;

public class Computer extends Spieler {
    //Random Züge Computer
    public static void computerZug(char[][] spielBrett) {

        Random rand = new Random();

        boolean ergebnis;
        int spielZug;
        do {
            spielZug = rand.nextInt(9) + 1;
            ergebnis = Spieler.istSpielzugErlaubt(spielZug, spielBrett);
        } while (ergebnis == false);

        System.out.println("Computer spielZug at position " + spielZug);
        Spielbrett.updateSpielbrett(spielZug, 2, spielBrett);
    }
}
