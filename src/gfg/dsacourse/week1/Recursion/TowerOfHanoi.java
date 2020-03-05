package gfg.dsacourse.week1.Recursion;

public class TowerOfHanoi {

	public static void hanoi(int n, String from, String to, String aux) {
		if (n == 1) {
			System.out.println("Move disk 1 from rod " + from + " to rod " + to);
			return;
		}
		hanoi(n - 1, from, aux, to);
		System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
		hanoi(n - 1, aux, to, from);

	}

	public static void main(String[] args) {
		hanoi(4, "A", "C", "B");  //from A which has 4 disks to C using B as auxilary

	}
}
