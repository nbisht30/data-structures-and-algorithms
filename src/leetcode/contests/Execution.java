package leetcode.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Execution {

    public static void main(String[] args) {
//        printPattern(1);
        dummy();
    }

    public static void dummy() {
        byte b = 0;
        b += 128;
        System.out.println(b);
    }

    public static void printPattern(int cols) {
        if (cols < 0 || cols % 2 == 0) {
            System.out.println("Invalid input!");
            return;
        }

        int rows = cols / 2 + 1;
        int stars = 1;
        System.out.println("Printing STAR pattern for rows: " + rows + " and columns: " + cols);
        for (int r = 0; r < rows; r++) {
            for (int sp = 0; sp < rows - r; sp++) {
                System.out.print(" ");
            }

            for(int st = 0; st < stars; st++) {
                System.out.print("*");
            }
            stars += 2;
            System.out.println();
        }
    }

}