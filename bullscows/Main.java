package bullscows;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Input the length of the secret code:");
        String lengthString = scanner.nextLine();
        int length;

        try {
            length = Integer.parseInt(lengthString);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.", lengthString);
            return;
        }

        System.out.println("Input the number of possible symbols in the code:");
        int possibleSymbols = scanner.nextInt() - 1;
        scanner.nextLine();

        if (length > 36 || possibleSymbols + 1 > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        } else if (possibleSymbols < length || length == 0 || possibleSymbols == 0) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d " +
                    "unique symbols.!", length, possibleSymbols);
            return;
        }
        Game game = new Game();
        game.start(length, possibleSymbols);
    }
}
