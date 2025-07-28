package collection;

import java.util.Deque;
import java.util.LinkedList;

// 允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），学名Deque

public class DequeDemo {

	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		deque.offerLast("A"); // A
		deque.offerLast("B"); // A <- B
		deque.offerFirst("C"); // C <- A <- B
		System.out.println(deque.pollFirst()); // C, 剩下A <- B
		System.out.println(deque.pollLast()); // B, 剩下A
		System.out.println(deque.pollFirst()); // A
		System.out.println(deque.pollFirst()); // null
	}

}
