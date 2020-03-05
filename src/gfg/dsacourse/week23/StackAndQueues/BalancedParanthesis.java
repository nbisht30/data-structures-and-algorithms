package gfg.dsacourse.week23.StackAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		String str;
		Scanner in = new Scanner(System.in);
		str = in.nextLine();
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < str.length()) {
			System.out.println(str.charAt(i));
			i++;
		}
	}
}
