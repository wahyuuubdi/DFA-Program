package umm.it.automata.uas.dfa;

import java.util.Scanner;

public class DFA {
    static char DfaTable[][];
    static int noOfStates;
    static int noOfTerminals;
    static String[] finalStates;

    public static void GetDFATable() {
        Scanner dFAScanner = new Scanner(System.in);
        Scanner getValues = new Scanner(System.in);
        Scanner finalStateScanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah statenya");
        noOfStates = getValues.nextInt() + 1;
        System.out.println("Masukkan jumlah terminalnya");
        noOfTerminals = getValues.nextInt() + 1;

        DfaTable = new char[noOfStates][noOfTerminals];

        System.out.println("Masukkan jumlah element yang ada di dalam DFA table");
        for (int i = 0; i < noOfStates; i++) {
            for (int j = 0; j < noOfTerminals; j++) {
                if (i == 0 && j == 0) {
                    DfaTable[0][0] = ' ';
                    continue;
                }
                DfaTable[i][j] = dFAScanner.next().charAt(0);
            }
        }

        System.out.println("Definisikan final statenya");
        System.out.println("Note: Gunakan spasi jika misalnya ada lebih dari 1 final statenya");
        finalStates = finalStateScanner.nextLine().split(" ");
    }

    public static char InitialState() {
        return DfaTable[1][0];
    }

    public static char NextState(char currentstate, char currentchar) {
        for (int i = 1; i < noOfStates; i++) {
            if (currentstate == DfaTable[i][0]) {
                for (int j = 1; j < noOfTerminals; j++) {
                    if (currentchar == DfaTable[0][j]) {
                        return DfaTable[i][j];
                    }
                }
            }
        }
        return '$';
    }

    public static boolean FinalState(char currentState) {
        for (String value : finalStates) {
            char charValue = value.charAt(0);
            if (charValue == currentState) {
                return true;
            }
        }
        return false;
    }
}