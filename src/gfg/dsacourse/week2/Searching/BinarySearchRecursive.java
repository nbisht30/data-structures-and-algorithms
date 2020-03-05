package gfg.dsacourse.week2.Searching;

public class BinarySearchRecursive {
	public static int binarySearch(int arr[], int beg, int end, int ele) {
		if (end < beg) {
			return -1;
		}
		int mid = beg + (end - beg) / 2;
		if (arr[mid] == ele) {
			return mid;
		} else if (arr[mid] < ele) {
			return binarySearch(arr, mid + 1, end, ele);
		} else {
			return binarySearch(arr, beg, mid - 1, ele);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 10, 23, 45, 56, 76, 87, 98, 123, 435, 555, 567, 576 };
		System.out.println(binarySearch(arr, 0, arr.length - 1, 87));
	}

}
