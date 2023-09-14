public class Main {
    public static void main(String[] args) {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    char [][] spielBrett = {{'_','|','_','|','_','|'},{'_','|','_','|','_','|'},{'_','|','_','|','_','|'}};
    ausgabeSpielbrett(spielBrett);
    }

    public static void ausgabeSpielbrett(char [][]spielBrett){  // Spielbrett Parameter

        for(char[] row : spielBrett){  // (for-each) for- Schleife für Array's...for (type variableName : arrayName)
            for( char[]Zeile : spielBrett){
                for(char c : row){              // Erst Zeile, dann Spalte = 2D-char-Array
                    System.out.println(c);
                }
                System.out.println();
            }
        }
    }

    public static void updateSpielbrett(int position, int spieler, char [][] spielBrett){

        char character;
        if(spieler == 1){
            character = 'X';            // ' '  statt " " weil char Datentyp
        } else {
            character = 'O';
        }
    }



}