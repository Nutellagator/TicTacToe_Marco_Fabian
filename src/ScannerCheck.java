import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerCheck {
    //Diese Methode prüft, ob ein Int vom Nutzer eingegeben wurde.
    //Wenn nicht, dann wird Neu-Eingabe aufgefordert.
    public int getInputInt() {
        Scanner scanner = new Scanner(System.in);

        int num;

        while (true) {


            try {
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Fehler: Sie haben keine Ganzzahl eingegeben. Bitte versuchen Sie es erneut.");
                scanner.nextLine(); // resettet den Scanner quasi

            }
        }
        return num;

    }

    //Diese Methode prüft, ob ein String vom Nutzer eingegeben wurde.
    //Wenn nicht, dann wird Neu-Eingabe aufgefordert.
    public String getInputString() {
        Scanner sc = new Scanner(System.in);

        System.out.print("EINGABE: ");
        String inputString;

        while (true) {

            inputString = sc.nextLine();

            if (inputString.isEmpty()) {
                System.out.print("Bitte Tippe ein [j] oder [n]: ");
            } else if (inputString.equalsIgnoreCase("j")) {
                //System.out.println("Deine Eingabe: " + inputString); -> zu Testzwecken
                break;

            } else if (inputString.equalsIgnoreCase("n")) {
                //System.out.println("Deine Eingabe: " + inputString); -> zu Testzwecken
                break;

            } else {
                System.out.print("Bitte Tippe ein [j] oder [n]: ");
            }
        }
        return inputString;

    }
}
