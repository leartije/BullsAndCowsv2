package bullscows;

public class Grader {

    private int bulls;
    private int cows;
    private final String secretNumber;

    public Grader(String secretNumber) {
        this.secretNumber = secretNumber;
    }
    protected void grade(String userNum) {
        for (int i = 0; i < secretNumber.length(); i++) {
            for (int j = 0; j < userNum.length(); j++) {
                if (i == j && secretNumber.charAt(i) == userNum.charAt(i)) {
                    bulls++;
                } else if (secretNumber.charAt(i) == userNum.charAt(j)) {
                    cows++;
                }
            }
        }
    }
    protected boolean msg() {
        if (bulls != secretNumber.length()) {
            System.out.printf("Grade: %d bull and %d cow%n", bulls, cows);
            bulls = 0;
            cows = 0;
            return false;
        }
        System.out.printf("Grade: %d bulls%nCongratulations! You guessed the secret code.%n", bulls);
        return true;
    }
}
