public class Main {
    public static void main(String[] args) {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    char [][] spielBrett = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
    ausgabeSpielbrett(spielBrett);
    updateSpielbrett(1,1,spielBrett);
    }

    public static void ausgabeSpielbrett(char [][]spielBrett){  // Spielbrett Parameter

        for(char[] row : spielBrett){  // (for-each) for- Schleife für Array's...for (type variableName : arrayName)
            for(char c : row){              // Erst Zeile, dann Spalte = 2D-char-Array
                System.out.print(c);        // print, nicht println
            }
            System.out.println();

        }
    }

    public static void updateSpielbrett(int position, int spieler, char [][] spielBrett){

        char character;
        if(spieler == 1){               // Spieler = 1, Computer = 2
            character = 'X';            // ' '  statt " " weil char Datentyp
        } else {
            character = 'O';
        }

        switch (position){
            case 1:
                    spielBrett[0][0] = character;
                    ausgabeSpielbrett(spielBrett);
                    break;
            default:  // Wenn kein Case eintrifft
                break;
    }


    }





}