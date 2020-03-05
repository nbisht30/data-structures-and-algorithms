package dsjava.SinglyLinkedLists;

public class SinglyLinkedList {

	private Node start;
	public int sizeOfList = 0;

	public boolean isEmpty() {
		return (start == null);
	}

	// inserts at the beginning of the list: O(1)
	public void insertFirst(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = start;
		start = temp;
		sizeOfList++;
	}

	// deletes at first: O(1)
	public void deleteFirst() {
		Node temp = new Node();
		temp = start.next;
		start = temp;
		sizeOfList--;
	}

	// inserts at end: O(n)
	public void insertEnd(int data) {
		Node last = new Node();
		last.data = data;
		last.next = null;

		Node temp = new Node();
		temp = start;
		if (start != null) {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = last;
			sizeOfList++;
		} else {
			insertFirst(data);
		}

	}

	public void deleteEnd() {
		Node temp;
		temp = start;

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		sizeOfList--;
	}

	public void displayList() {
		Node temp;
		temp = start;

		while (temp.next != null) {
			System.out.print("{" + temp.data + "}, ");
			temp = temp.next;
		}
		System.out.println("{" + temp.data + "}");
	}

	public int findMiddle() {
		Node slowPointer;
		Node fastPointer;
		slowPointer = fastPointer = start;

		while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer.data;
	}

	public void reverse() {
		Node curr;
		Node prev = null;
		Node nextPart = null;
		curr = start;
		while (curr.next != null) {
			// store the latter half before we change current pointer to previous node
			nextPart = curr.next;
			// point current to prev node
			curr.next = prev;
			prev = curr;
			curr = nextPart;
		}
		curr.next = prev;
		start = curr;
	}

	public void changeAlternateNodes() {
		Node curr;
		Node prev;
		Node nextPart = null;
		curr = prev = start;
		start = curr.next; // making second node the start
		while (curr.next != null && curr.next.next != null) {
			// store the latter half
			nextPart = curr.next.next;
			curr.next.next = curr;
			prev.next = curr.next;
			curr.next = nextPart;
			prev = curr;
			curr = nextPart;
		}
		
	}

	public void recursiveReversal() {
		Node prev = null;
		reverseUtil(start, prev);
	}

	Node reverseUtil(Node curr, Node prev) {

		/* If last node mark it head */
		if (curr.next == null) {
			start = curr;

			/* Update next to prev node */
			curr.next = prev;
			return null;
		}

		/* Save curr->next node for recursive call */
		Node next1 = curr.next;

		/* and update next .. */
		curr.next = prev;

		reverseUtil(next1, curr);
		return start;
	}
}