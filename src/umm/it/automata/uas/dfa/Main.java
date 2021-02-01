package umm.it.automata.uas.dfa;

import java.util.Scanner;

public class Main {
    static char currentChar;
    static char currentState;
    static char[] LineCharArray;
    static int LineCharArrayCount = 0;

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        DFA.GetDFATable();

        while (true) {
            System.out.println("Masukkan nilai stringnya");
            String inputString = inputScanner.nextLine();
            if (inputString.contentEquals("exit") || inputString.contentEquals("no"))
                break;
            else {
                LineCharArray = inputString.toCharArray();
                LineCharArrayCount = 0;
                Algorithm();
            }
        }
    }

    private static void Algorithm() {
        currentState = DFA.InitialState();
        currentChar = NextChar();
        while (currentChar != '$') {
            currentState = Move(currentState, currentChar);
            currentChar = NextChar();
        }
        System.out.println(FinalStateChecker());
    }

    private static char NextChar() {
        if (LineCharArray == null || LineCharArrayCount == LineCharArray.length) {
            return '$';
        } else {
            return LineCharArray[LineCharArrayCount++];
        }
    }

    private static char Move(char currentstate, char currentchar) {
        return DFA.NextState(currentstate, currentchar);
    }

    private static String FinalStateChecker() {
        if (DFA.FinalState(currentState)) {
            return "Accepted";
        } else {
            return "Rejected";
        }
    }
}