public class Main {
    public static void main(String[] args) {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    char [][] spielBrett = {{'_','|','_','|','_','|'},{'_','|','_','|','_','|'},{'_','|','_','|','_','|'}};
    ausgabeSpielbrett(spielBrett);
    }

    public static void ausgabeSpielbrett(char [][]spielBrett){  // Spielbrett Parameter

        for(char[] row : spielBrett){  // (for-each) for- Schleife für Array's...for (type variableName : arrayName)
            for( char[]Zeile : spielBrett){
                for(char c : row){              // Erst Zeile, dann Spalte
                    System.out.println(c);
                }
                System.out.println();
            }
        }
    }





}