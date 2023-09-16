import java.util.Random;
import java.util.Scanner;

public class Main {

    static int spielerPunkte;
    static int computerPunkte;
    static Scanner eingabe = new Scanner(System.in);
    public static void main(String[] args) {


    Spielbrett s1 = new Spielbrett();

        boolean gameOver = false;
        boolean nochmalSpielen = true;
        ausgabeSpielbrett(s1.getSpielBrett());

     //TODO call-by-value & call-by-reference wiederholen
    // Game-Loop + ob nochmal gespielt werden soll
    while(nochmalSpielen == true) {
        while (gameOver == false) { //Game-Loop
            spielerZug(s1.getSpielBrett());
            gameOver = hatGewonnen(s1.getSpielBrett());
            if (gameOver == true) {
                break;
            }

            computerZug(s1.getSpielBrett());
            gameOver = hatGewonnen(s1.getSpielBrett());
            if (gameOver == true) {
                break;
            }
        }
            System.out.println("Spieler Punkte: " +spielerPunkte);
            System.out.println("Computer Punkte: "+ computerPunkte);
            System.out.println("Möchtest du nochmal spielen?  (J / N)");
            eingabe.nextLine();
            String ergebnis = eingabe.nextLine();

            switch (ergebnis){
                case "J":
                case "j":
                    nochmalSpielen = true;
                    System.out.println("Ein neues Game startet!");
                    resetSpielbrett(s1.getSpielBrett());
                    gameOver = false;
                    ausgabeSpielbrett(s1.getSpielBrett());
                    break;

                case "N":
                case "n":
                    nochmalSpielen = false;
                    System.out.println("Bis zum nächsten mal!");
                    break;
                default:
                    break;
            }

        }
    }

// TODO: UpdateTest erfolgreich
//        updateSpielbrett(2,1,spielBrett);
//        updateSpielbrett(3,1,spielBrett);
//        updateSpielbrett(4,2,spielBrett);
//        updateSpielbrett(5,2,spielBrett);
//        updateSpielbrett(6,2,spielBrett);

// TODO: Wie greifen die Methoden auf die Werte einer anderen Methode zu

        /*spielerZug(spielBrett);
        computerZug(spielBrett);
        spielerZug(spielBrett);
        computerZug(spielBrett);*/


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
    //wo der jeweilige Spieler sein Zeichen (X oder O) setzen möchte
    public static void spielerZug(char [][] spielBrett){

        System.out.println("Nächsten Zug eingeben (1-9)");


        int spielZug = eingabe.nextInt();

        boolean ergebnis = istSpielzugErlaubt(spielZug,spielBrett);

        while (ergebnis == false) {  //TODO Kurzschreibweise wiederholen/lernen
            System.out.println("Feld wurde bereits gewählt");
            spielZug = eingabe.nextInt();
            ergebnis = istSpielzugErlaubt(spielZug, spielBrett);
        }

        System.out.println("Position " + spielZug + " gewählt.");
        updateSpielbrett(spielZug, 1, spielBrett);

    }

    //Ist das jeweilige Feld noch bespielbar
    public static boolean istSpielzugErlaubt(int spielZug, char[][] spielBrett){

        switch (spielZug){
            case 1:
                if(spielBrett[0][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 2:
                if(spielBrett[0][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 3:
                if(spielBrett[0][4] == '_'){
                    return true;
                } else{
                    return false;
                }

            case 4:
                if(spielBrett[1][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 5:
                if(spielBrett[1][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 6:
                if(spielBrett[1][4] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 7:
                if(spielBrett[2][0] == ' '){        // Letztes Array leerzeichen wegen Augenschmaus
                    return true;
                } else{
                    return false;
                }
            case 8:
                if(spielBrett[2][2] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 9:
                if(spielBrett[2][4] == ' '){
                    return true;
                } else{
                    return false;
                }

            default:
                return false;
        }

    }

    //Random Züge Computer
    public static void computerZug(char [][] spielBrett) {

        Random rand = new Random();

        boolean ergebnis;
        int spielZug;
        do {
            spielZug = rand.nextInt(9) + 1;
            ergebnis = istSpielzugErlaubt(spielZug, spielBrett);
        } while (ergebnis == false);

        System.out.println("Computer spielZug at position " + spielZug);
        updateSpielbrett(spielZug, 2, spielBrett);
    }

    public static boolean hatGewonnen(char [][] spielBrett){

        //Horizontal
        if(spielBrett[0][0] == 'X'&& spielBrett[0][2] == 'X' && spielBrett [0][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[0][0] == 'O'&& spielBrett[0][2] == 'O' && spielBrett [0][4] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }
        if(spielBrett[1][0] == 'X'&& spielBrett[1][2] == 'X' && spielBrett [1][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[1][0] == 'O'&& spielBrett[1][2] == 'O' && spielBrett [1][4] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }
        if(spielBrett[2][0] == 'X'&& spielBrett[2][2] == 'X' && spielBrett [2][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[2][0] == 'O'&& spielBrett[2][2] == 'O' && spielBrett [2][4] == 'O' ) {
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        //Vertikal
        if(spielBrett[0][0] == 'X'&& spielBrett[1][0] == 'X' && spielBrett [2][0] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[0][0] == 'O'&& spielBrett[1][0] == 'O' && spielBrett [2][0] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        if(spielBrett[0][2] == 'X'&& spielBrett[1][2] == 'X' && spielBrett [2][2] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[0][2] == 'O'&& spielBrett[1][2] == 'O' && spielBrett [2][2] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        if(spielBrett[0][4] == 'X'&& spielBrett[1][4] == 'X' && spielBrett [2][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[0][4] == 'O'&& spielBrett[1][4] == 'O' && spielBrett [2][4] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        //Diagonal
        if(spielBrett[0][0] == 'X'&& spielBrett[1][2] == 'X' && spielBrett [2][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[0][0] == 'O'&& spielBrett[1][2] == 'O' && spielBrett [2][4] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        if(spielBrett[2][0] == 'X'&& spielBrett[1][2] == 'X' && spielBrett [0][4] == 'X' ){
            System.out.println("Spieler gewinnt");
            spielerPunkte++;
            return true;
        }
        if(spielBrett[2][0] == 'O'&& spielBrett[1][2] == 'O' && spielBrett [0][4] == 'O' ){
            System.out.println("Computer Gewinnt");
            computerPunkte++;
            return true;
        }

        //Unentschieden  (Wenn die Felder nichtmehr leer sind)
        if(spielBrett[0][0] != '_' && spielBrett[0][2] != '_' && spielBrett[0][4] != '_' && spielBrett[1][0] !='_'&&
                spielBrett[1][2] != '_' && spielBrett[1][4] != '_' && spielBrett[2][0] != ' ' && spielBrett[2][2] != ' ' && spielBrett[2][4] != ' '){
            System.out.println("Unentschieden");
            return true;
        }
        return false;
    }
    // Wenn nochmal gespielt werden soll, dann wird Spielfeld (Arrays) zurückgesetzt
    public static void resetSpielbrett(char [][] spielBrett){
        spielBrett[0][0] = '_';
        spielBrett[0][2] = '_';
        spielBrett[0][4] = '_';
        spielBrett[1][0] = '_';
        spielBrett[1][2] = '_';
        spielBrett[1][4] = '_';
        spielBrett[2][0] = ' ';
        spielBrett[2][2] = ' ';
        spielBrett[2][4] = ' ';

    }
}