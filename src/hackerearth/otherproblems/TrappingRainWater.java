package hackerearth.otherproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        ArrayList<Integer> arr = new ArrayList<>();
        String[] inputArr = input.split(" ");
        int itr = 0;
        while (itr < inputArr.length) {
            arr.add(Integer.parseInt(inputArr[itr]));
            itr++;
        }
        // arr.forEach(item -> System.out.print(item + " "));
        int[] arrML = new int[2];
        int size = arr.size();
        int sum = 0;
//		System.out.println("Input the index: ");
//		int mid = in.nextInt();
//		arrML = maxLR(arr, mid);
//		System.out.println("Max on left and right of: A[" + mid + "]: " + arr.get(mid));
//		System.out.println(arrML[0]);
//		System.out.println(arrML[1]);

        for (int i = 0; i < size; i++) {
            arrML = maxLR(arr, i);
//			System.out.println("Max on left and right of: A[" + i + "]: " + arr.get(i));
//			System.out.println(arrML[0]);
//			System.out.println(arrML[1]);
            if (min(arrML[0], arrML[1]) > 0)
                sum += (min(arrML[0], arrML[1]) - arr.get(i));
//			System.out.println("Sum till " + i + "th element: " + sum);
        }


        System.out.println(sum);

    }

    public static int min(int a, int b) {
        if (a <= b)
            return a;
        else
            return b;
    }

    public static int[] maxLR(ArrayList<Integer> list, int i) {
        int retArr[] = new int[2];
        retArr[0] = list.get(i);
        retArr[1] = list.get(i);
        for (int j = 0; j < i; j++) {
            if (list.get(j) >= retArr[0]) {
                retArr[0] = list.get(j);
            }
        }

        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(j) >= retArr[1]) {
                retArr[1] = list.get(j);
            }
        }
        return retArr;
    }
}
//1 3 7 5 1 3 4 5 2 7 3 1 4