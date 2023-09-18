import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpielerTest {

    @Test
    void getSpielerNummer() {
        System.out.println("test getSpielerNummer");
        Spieler spieler1 = new Spieler(1);
        assertEquals(spieler1.getSpielerNummer(), 1);  //Methode aus Assert Klasse. Bei Run (unten links) muss "Test passed" rauskommen
    }                                                       // Objekt erstellen nötig weil nicht static

    @Test
    void setSpielerNummer() {
        System.out.println("test setSpielerNummer");
        Spieler spieler1 = new Spieler(1);
        spieler1.setSpielerNummer(2);
        assertEquals(spieler1.getSpielerNummer(), 2);
    }

    @Test
    void getPunkte() {
        System.out.println("test getPunkte");
        Spieler spieler1 = new Spieler(1);
        assertEquals(spieler1.getPunkte(),0);
    }

    @Test
    void setPunkte() {
        System.out.println("test setPunkte");
        Spieler spieler1 = new Computer(2);
        spieler1.setPunkte(1);
        assertEquals(spieler1.getPunkte(),1);
    }
}