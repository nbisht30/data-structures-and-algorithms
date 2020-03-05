package gfg.dsacourse.week23.StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int size = 0;

	boolean isEmptyStack() {
		return (size == 0);
	}

	void push(int x) {
		q2.add(x);
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		Queue<Integer> temp = new LinkedList<Integer>();
		q1 = q2;
		q2 = temp;
		size++;
	}

	int pop() {
		if (size > 0) {
			size--;
			return q1.remove();
		}
		return -1;
	}

	void displayStack() {

	}
	public static void main(String args[]) {
		StackUsingQueues stack = new StackUsingQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		while (!stack.isEmptyStack()) {
			System.out.println(stack.pop());
		}

	}

}
