import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // Multidimensionales-Array, Darstellung des Spielfeldes
    // Spielbrett enthält 3 Arrays, jedes Array enthält Wertebereich 0-4 (5 Werte mit Komma getrennt)
    char [][] spielBrett = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
    ausgabeSpielbrett(spielBrett);
    updateSpielbrett(1,1,spielBrett);

// TODO: UpdateTest erfolgreich
//        updateSpielbrett(2,1,spielBrett);
//        updateSpielbrett(3,1,spielBrett);
//        updateSpielbrett(4,2,spielBrett);
//        updateSpielbrett(5,2,spielBrett);
//        updateSpielbrett(6,2,spielBrett);

        spielerZug(spielBrett);

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

        switch (position){  // Positionen im Feld
            case 1:
                spielBrett[0][0] = character;  // character X oder O
                ausgabeSpielbrett(spielBrett);
                break;
            case 2:
                spielBrett[0][2] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 3:
                spielBrett[0][4] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 4:
                spielBrett[1][0] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 5:
                spielBrett[1][2] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 6:
                spielBrett[1][4] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 7:
                spielBrett[2][0] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 8:
                spielBrett[2][2] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            case 9:
                spielBrett[2][4] = character;
                ausgabeSpielbrett(spielBrett);
                break;
            default:  // Wenn kein Case eintrifft
                break;
        }


    }

    public static void spielerZug(char [][] spielBrett){

        System.out.println("Nächsten Zug eingeben (1-9)");
        Scanner eingabe = new Scanner(System.in);

        int spielZug = eingabe.nextInt();
        updateSpielbrett(spielZug, 1, spielBrett);

    }



}