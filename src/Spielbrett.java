public class Spielbrett {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    // Spielbrett enthält 3 Arrays, jedes Array enthält Wertebereich 0-4 (5 Werte mit Komma getrennt)
    private char [][] spielBrett = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};  // Letztes Array leerzeichen wegen Augenschmaus

    public char[][] getSpielBrett() {
        return spielBrett;
    }

    public void setSpielBrett(char[][] spielBrett) {
        this.spielBrett = spielBrett;
    }
}
