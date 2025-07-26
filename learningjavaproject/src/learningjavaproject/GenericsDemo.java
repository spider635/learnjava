package learningjavaproject;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {

		// 无编译器警告:
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");

		// 无强制转型:
		String first = list.get(0);
		String second = list.get(1);

		System.out.println(first);
		System.out.println(second);

	}

}

class Pair<T> {
	private T first;
	private T last;

	public Pair(T first, T last) {
		this.first = first;
		this.last = last;
	}

	public T getFirst() {
		return first;
	}

	public T getLast() {
		return last;
	}
}
