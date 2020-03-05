package dsjava.Arrays;

import java.util.ArrayList;

public class Tutorial {

	public static void main(String[] args) {
		int[] Arr = new int[5]; // basic one dimensional array

		ArrayList<Integer> list1 = new ArrayList<>(10); // declaration of an integer type ArrayList of size 10.
		/*
		 * In ArrayLists you cannot use primitive data types, you have to use Wrapper
		 * classes. To Do: Why can't we use primitive types in Java Collections?
		 */

		/* IMPORTANT ArrayList METHODS:- */

		/*
		 * add(item): adds element to the end of the list O(1) if list size is not
		 * exceeding. O(n) if size needs to be exceeded.
		 */
		for (int i = 1; i <= 9; i++) // adding 9 elements
		{
			list1.add(i);
		}

		// adding one element before the size of ArrayList exceeds
		long time_start = System.nanoTime();
		list1.add(10);
		long time_end = System.nanoTime();
		System.out.println("Basic add() run time: " + (time_end - time_start));

		// adding one element to exceed size of ArrayList
		time_start = System.nanoTime();
		list1.add(11);
		time_end = System.nanoTime();
		System.out.println("add() run time after size exceeding: " + (time_end - time_start));
		System.out.printf("\n");
		/*
		 * size() : Returns the total no. of elements added in the array and not the
		 * declared size
		 */
		ArrayList<Integer> list2 = new ArrayList<>(10);
		System.out.println("Size of list2: " + list2.size());
		System.out.printf("\n");

		// remove(index): remove element at index : O(n)
		System.out.print("List1 before removing 2 elements: ");
		list1.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");
		list1.remove(2);
		list1.remove(1);
		System.out.print("List1 after removing 2 elements: ");
		list1.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		// add(index,item): adding an element at a index: O(n) worst case.
		list1.add(0, 1111);
		System.out.print("List1 after adding at index 0: ");
		list1.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");
		/*
		 * boolean addAll(Collection c): This method adds each element of the Specific
		 * collection type at the end of the ArrayList. It returns True if collection is
		 * successfully added, and returns false if it is not. If the collection passed
		 * in as an argument is null then it throws Null Pointer Exception.
		 */
		list2.add(100);
		list2.addAll(list1);
		System.out.print("Appended List2, by List1: ");
		list2.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		/*
		 * boolean addAll(int index, Collection c): This methods add each element of the
		 * Specific collection type at the specified index as mentioned in the argument.
		 */
		list2.addAll(4, list1);
		System.out.print("Appended List2 at index 4, by List1: ");
		list2.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		/* Cloning an ArrayList */
		// method1
		ArrayList<Integer> list3 = (ArrayList<Integer>) list1.clone();
		System.out.print("List3 after cloning from List1: ");
		list3.forEach(item -> System.out.print(item + " "));
		// method2
		ArrayList<Integer> list4 = new ArrayList<>(list1);
		System.out.printf("\n\n");
		System.out.print("List4 after cloning from List1 during declaration: ");
		list4.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		// clear() : removes all elements
		list4.clear();
		System.out.print("List4 after removal: ");
		if((list4.isEmpty())) 
			System.out.print("List is empty");
		list4.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		/*
		 * boolean contains(Object element):
		 * 
		 * This method returns true if the calling ArrayList object contains the
		 * specific element as given in the argument list, otherwise it returns false.
		 */
		System.out.println("Does list1 contain 1111: " + list1.contains(1111));
		System.out.printf("\n");
		/*
		 * void ensureCapacity(int minCapacity):
		 * 
		 * This method ensures that the size of arraylist is not less than mentioned in
		 * the argument list, if it is less then it increases its size up to as
		 * mentioned in the argument of this method.
		 */
		list1.ensureCapacity(15);

		/*
		 * Object get(int index):
		 * 
		 * It returns the element present in the mentioned position in the arraylist. If
		 * the index mentioned in the argument is more then the size of arraylist ,then
		 * it throws Index Out of Bound Exception.
		 */
		System.out.println("Element at 3rd index in List1: " + list1.get(2));
		System.out.printf("\n");

		/*
		 * int indexOf(Object o):
		 * 
		 * This method gives the index of the element as mentioned in the arraylist
		 * starting from zero position. It will return -1 , if that element is not
		 * present in the arraylist.
		 */
		System.out.println("Give the index of 10 in List1: " + list1.indexOf(10));
		System.out.printf("\n");

		/*
		 * int lastIndexOf(Object o):
		 * 
		 * This method gives the index of the element as mentioned in the arraylist
		 * starting from last position. It will return -1 , if that element is not
		 * present in the arraylist.
		 */
		System.out.println("Last index of 1111 in List2: " + list2.lastIndexOf(1111));
		System.out.printf("\n");

		/*
		 * subList(int first, int last).clear():
		 * 
		 * It deletes the group of elements from the first to last as mentioned in the
		 * argument. It includes the first index and excludes the last index
		 */
		list2.subList(0, 5).clear();
		System.out.print("Removing range 0 to 5 from List2: ");
		list2.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		/*
		 * Object set(int index, Object element):
		 * 
		 * This method replaces the content at index mentioned with the element given in
		 * argument list.
		 */
		list2.set(0, 100);
		System.out.print("Index[0] of List2 changed: ");
		list2.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		/*
		 * Object[] toArray():
		 * 
		 * This method converts the ArrayList to its corresponding array. This method
		 * acts as Bridge between Arraylist and Array.
		 */
		Object[] obj=list2.toArray();
		/*
		 * void trimToSize():
		 * 
		 * This method decreases the size of arraylist to its actual size. This method
		 * helps in saving extra memory allocated at start, and ultimately increases the
		 * performance.
		 */
		list2.trimToSize();
		/*
		 * Boolean isEmpty()
		 * 
		 * As the name specifies this method checks whether an ArrayList is empty or
		 * not. If it is empty this method will return true, else it will return false
		 */

		/*
		 * boolean remove(Object o):
		 * 
		 * This method removes first Occurrence of the element specified in the argument
		 * list from the ArrayList.
		 */
		list2.remove((Integer)11);
		System.out.print("First occurence 11 removed from List2: ");
		list2.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		// basic for-each to print
		System.out.println("Printed by basic for-each:-");
		for (int o : list1) {
			System.out.print(o + " ");
		}
		System.out.printf("\n\n");

		/* Using lambdas to print lists:- */
		System.out.println("Printed by lambda exp1:-");
		list1.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		System.out.println("Printed by lambda exp2:-");
		list1.forEach(item -> {
			System.out.print(item + " ");
		});
		System.out.printf("\n\n");

		System.out.println("Printed by lambda exp3:-");
		list1.forEach(item -> System.out.print(item + " "));
		System.out.printf("\n\n");

		System.out.println("Printed by lambda exp4:-");
		list1.forEach(System.out::print);
		System.out.printf("\n\n");

	}

}
