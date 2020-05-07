package gfg.dsacourse.week23.CircularLinkedLists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList ilist = new CircularLinkedList();
		System.out.println("Size: " + ilist.sizeOfList);
		ilist.insertFirst(5);
		ilist.insertFirst(4);
		ilist.insertFirst(3);
		ilist.insertFirst(2);
		ilist.insertFirst(1);
		System.out.println("List items:-");
		ilist.displayList();
		System.out.println("Size: " + ilist.sizeOfList);
		ilist.deleteFirst();
		ilist.deleteFirst();
		ilist.insertFirst(1);
		ilist.insertEnd(1);
		ilist.insertFirst(1);
		ilist.deleteEnd();
		System.out.println("List items:-");
		ilist.displayList();
		System.out.println("Size: " + ilist.sizeOfList);
		System.out.println("Middle: "+ilist);
		
		

	}

}
