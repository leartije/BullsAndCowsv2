package bullscows;

public class Game {
    public void start(int length, int poss) {
        NumberGenerator secretNum = new NumberGenerator();
        Grader grader = new Grader(secretNum.createRandomNum(length, poss));
        System.out.println(secretNum.preMsg(length, poss));
        System.out.println("Okay, let's start a game!");
        int turns = 1;
        boolean exit = false;
        while (!exit) {
            System.out.println("Turn: " + turns++ + ":");
            String input = Main.scanner.nextLine();
            grader.grade(input);
            exit = grader.msg();
        }
    }
}
