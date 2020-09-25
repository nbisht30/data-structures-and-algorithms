package implementations.recursion;

/*
 * Print the following output using recursion
 * 
 * 5
 * 4
 * 3
 * 2
 * 1
 * 1
 * 2
 * 3
 * 4
 * 5
 * */
public class DoingWorkBeforeAndAfterACall {
	public static void main(String[] args) {
		func(5);
	}
	
	public static void func(int n) {
		if(n == 0)
			return;
		System.out.println(n);
		func(n - 1);
		System.out.println(n);
	}
}
