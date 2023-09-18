import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpielerTest {

    @Test
    void getSpielerNummer() {
        System.out.println(" testGetSpielerNummer");
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
    }

    @Test
    void setPunkte() {
    }
}