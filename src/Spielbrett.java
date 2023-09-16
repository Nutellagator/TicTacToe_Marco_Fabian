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

    //Methode um das Spielfeld mit den Werten des Arrays zu erzeugen
    // { 1. {'_','|','_','|','_'}, 2. {'_', '|', '_','|','_'}, 3. {' ','|',' ','|',' '}};
    public static void ausgabeSpielbrett(char [][]spielBrett){  // Spielbrett Parameter

        for(char[] row : spielBrett){  // (for-each) for- Schleife für Array's...for (type variableName : arrayName)
            for(char c : row){              // Zählt die Indexe(Inhalte, 3x5 Inhalte) - Erst Zeile, dann Spalte = 2D-char-Array
                System.out.print(c);        // print, nicht println
            }
            System.out.println(); // Erste for Schleife

        }
    }

}
