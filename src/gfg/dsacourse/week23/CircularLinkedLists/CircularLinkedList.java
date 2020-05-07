package gfg.dsacourse.week23.CircularLinkedLists;
/*
From the course: Practical Data Structures & Algorithms in Java + HW
 */
public class CircularLinkedList {

	private Node rear;
	public int sizeOfList = 0;

	public boolean isEmpty() {
		return (rear == null);
	}

	// inserts at the beginning of the list: O(1)
	public void insertFirst(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = rear;
		rear = temp;
		sizeOfList++;
	}

	// deletes at first: O(1)
	public void deleteFirst() {
		Node temp = new Node();
		temp = rear.next;
		rear = temp;
		sizeOfList--;
	}

	// inserts at end: O(n)
	public void insertEnd(int data) {
		Node temp = new Node();
		temp = rear;

		while (temp.next != null) {
			temp = temp.next;
		}
		Node last = new Node();
		last.data = data;
		last.next = null;
		temp.next = last;
		sizeOfList++;
	}

	public void deleteEnd() {
		Node temp = new Node();
		temp = rear;

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		sizeOfList--;
	}

	public void displayList() {
		Node temp = new Node();
		temp = rear;

		while (temp.next != null) {
			System.out.print("{" + temp.data + "}, ");
			temp = temp.next;
		}
		System.out.println("{" + temp.data + "}");
	}
}