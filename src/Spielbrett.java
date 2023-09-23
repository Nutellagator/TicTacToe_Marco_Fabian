public class Spielbrett {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    // Spielbrett enthält 3 Arrays, jedes Array enthält Wertebereich 0-4 (5 Werte mit Komma getrennt)
    private char[][] spielBrett = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}};  // Letztes Array leerzeichen wegen Augenschmaus

    /*private static int runden = 0;


    //Methoden
    public int getRunden() {
        return runden;
    }

    public void setRunden(int runden) {
        Spielbrett.runden = runden;
    }*/
    public char[][] getSpielBrett() {
        return spielBrett;
    }

    public void setSpielBrett(char[][] spielBrett) {
        this.spielBrett = spielBrett;
    }

    //Methode um das Spielfeld mit den Werten des Arrays zu erzeugen
    // { 1. {'_','|','_','|','_'}, 2. {'_', '|', '_','|','_'}, 3. {' ','|',' ','|',' '}};
    public static void ausgabeSpielbrett(char[][] spielBrett) {  // Spielbrett Parameter

        for (char[] row : spielBrett) {  // (for-each) for- Schleife für Array's...for (type variableName : arrayName)
            for (char c : row) {              // Zählt die Indexe(Inhalte, 3x5 Inhalte) - Erst Zeile, dann Spalte = 2D-char-Array
                System.out.print(c);        // print, nicht println
            }
            System.out.println(); // Erste for Schleife

        }
    }

    public static void updateSpielbrett(int position, int spieler, char[][] spielBrett) {

        // das für den Spieler der gerade am Zug ist, das richtige Symbol eingesetzt wird ( X oder O )
        char character;
        if (spieler == 1) {               // Spieler = 1, Computer = 2
            character = 'X';            // ' '  statt " " weil char Datentyp
        } else {
            character = 'O';
        }

        // Um zu bestimmen an welche Stelle im Spielfeld (Array) das jeweilige Zeichen gesetzt wird ( X oder O )
        switch (position) {  // Positionen im Feld
            case 1:
                spielBrett[0][0] = character;  // character X oder O
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 2:
                spielBrett[0][2] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 3:
                spielBrett[0][4] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 4:
                spielBrett[1][0] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 5:
                spielBrett[1][2] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 6:
                spielBrett[1][4] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 7:
                spielBrett[2][0] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 8:
                spielBrett[2][2] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            case 9:
                spielBrett[2][4] = character;
                Spielbrett.ausgabeSpielbrett(spielBrett);
                break;
            default:  // Wenn kein Case eintrifft
                break;
        }
    }

    public static boolean hatGewonnen(char[][] spielBrett) {  // TODO Schleife (+2)

        //Horizontal
        for (int i = 0; i < 3; i++) {
            if (spielBrett[i][0] == 'X' && spielBrett[i][2] == 'X' && spielBrett[i][4] == 'X') {
                System.out.println("Spieler 1 gewinnt");
                return true;
            } else if (spielBrett[i][0] == 'O' && spielBrett[i][2] == 'O' && spielBrett[i][4] == 'O') {
                System.out.println("Spieler 2 gewinnt");
                return true;
            }
        }
        //Vertikal

        for (int i = 0; i < 5; i += 2) {
            if (spielBrett[0][i] == 'X' && spielBrett[1][i] == 'X' && spielBrett[2][i] == 'X') {
                System.out.println("Spieler 1 gewinnt");
                return true;
            } else if (spielBrett[0][i] == 'O' && spielBrett[1][i] == 'O' && spielBrett[2][i] == 'O') {
                System.out.println("Spieler 2 gewinnt");
                return true;
            }
        }


        //Diagonale
        if ((spielBrett[0][0] == 'X' && spielBrett[1][2] == 'X' && spielBrett[2][4] == 'X') ||
                (spielBrett[2][0] == 'X' && spielBrett[1][2] == 'X' && spielBrett[0][4] == 'X')) {
            System.out.println("Spieler 1 gewinnt");
            return true;
        } else if ((spielBrett[0][0] == '0' && spielBrett[1][2] == '0' && spielBrett[2][4] == '0') ||
                (spielBrett[2][0] == '0' && spielBrett[1][2] == '0' && spielBrett[0][4] == '0')) {
            System.out.println("Spieler 2 gewinnt");
            return true;
        }

        return false;
    }

    public static boolean istUnentschieden(char[][] spielBrett) {
        //Unentschieden  (Wenn die Felder nichtmehr leer sind)
        //hatGewonnen(spielBrett);
        if (hatGewonnen(spielBrett) == false && (spielBrett[0][0] != '_' && spielBrett[0][2] != '_' && spielBrett[0][4] != '_' && spielBrett[1][0] != '_' &&
                spielBrett[1][2] != '_' && spielBrett[1][4] != '_' && spielBrett[2][0] != ' ' && spielBrett[2][2] != ' ' && spielBrett[2][4] != ' ')) {
            return true;
        }
        return false;
    }

    // Wenn nochmal gespielt werden soll, dann wird Spielfeld (Arrays) zurückgesetzt
/*    public static void resetSpielbrett(char[][] spielBrett) {
        spielBrett[0][0] = '_';
        spielBrett[0][2] = '_';
        spielBrett[0][4] = '_';
        spielBrett[1][0] = '_';
        spielBrett[1][2] = '_';
        spielBrett[1][4] = '_';
        spielBrett[2][0] = ' ';
        spielBrett[2][2] = ' ';
        spielBrett[2][4] = ' ';

    }*/
}
