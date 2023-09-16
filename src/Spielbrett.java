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
    public static void updateSpielbrett(int position, int spieler, char [][] spielBrett){

        // das für den Spieler der gerade am Zug ist, das richtige Symbol eingesetzt wird ( X oder O )
        char character;
        if(spieler == 1){               // Spieler = 1, Computer = 2
            character = 'X';            // ' '  statt " " weil char Datentyp
        } else {
            character = 'O';
        }

        // Um zu bestimmen an welche Stelle im Spielfeld (Array) das jeweilige Zeichen gesetzt wird ( X oder O )
        switch (position){  // Positionen im Feld
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

}
