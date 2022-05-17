package bullscows;

import java.util.Random;

public class NumberGenerator {
    private final StringBuilder nums = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
    private final Random random = new Random();
    protected String createRandomNum(int secretCodeLength, int possibleSymbols) {
        StringBuilder secretCode = new StringBuilder();
        StringBuilder sub = new StringBuilder(nums.subSequence(0, possibleSymbols + 1));
        while (secretCodeLength > secretCode.length()) {
            int index = random.nextInt(sub.length());
            if (sub.charAt(index) == '0' && secretCode.length() == 0) {
                continue;
            }
            secretCode.append(sub.charAt(index));
            sub.deleteCharAt(index);
        }
        return secretCode.toString();
    }
    protected String preMsg(int length, int possLength) {
        String stars = "*".repeat(length);
        if (possLength < 10) {
            return String.format("The secret is prepared: %s (%d-%d)", stars, 0, possLength);
        }
        return String.format("The secret is prepared: %s (0-9, %c-%c)", stars, 'a', nums.charAt(possLength));
    }
}
