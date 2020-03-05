package dsjava.SinglyLinkedLists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList ilist = new SinglyLinkedList();
		System.out.println("Size: " + ilist.sizeOfList);
		ilist.insertFirst(5);
		ilist.insertFirst(4);
		ilist.insertFirst(3);
		ilist.insertFirst(2);
		ilist.insertFirst(6);
		ilist.insertFirst(2);
		ilist.insertFirst(6);
		System.out.println("List items:-");
		ilist.displayList();
		
		System.out.println("Alternate nodes:-");
		ilist.changeAlternateNodes();


	}

}
