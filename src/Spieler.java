import java.util.Scanner;  //POJO

public class Spieler {

    private int Punkte = 0;



    private int spielerNummer;

    public Spieler(int spielerNummer) {
        this.spielerNummer = spielerNummer;
    }


    public int getSpielerNummer() {
        return spielerNummer;
    }

    public void setSpielerNummer(int spielerNummer) {
        this.spielerNummer = spielerNummer;
    }

    public int getPunkte() {
        return Punkte;
    }

    public void setPunkte(int punkte) {
        Punkte = punkte;
    }


}
