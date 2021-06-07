package codingblocks.recursion;

/*Print the following output using recursion
 * 5
 * 3
 * 1
 * 2
 * 4
 * */
public class SkippingNumbers {
	public static void main(String[] args) {
		func(5);
	}

	public static void func(int n) {
		if (n < 0) {
			return;
		}
		System.out.println(n);
		func(n - 2);

	}
}
