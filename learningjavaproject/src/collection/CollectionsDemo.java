package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {

//		List<String> list = new ArrayList<>();
//		list.add("apple");
//		list.add("pear");
//		list.add("orange");
//		// 排序前:
//		System.out.println(list);
//		Collections.sort(list);
//		// 排序后:
//		System.out.println(list);

//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			list.add(i);
//		}
//		// 洗牌前:
//		System.out.println(list);
//		// 洗牌:
//		Collections.shuffle(list);
//		// 洗牌后:
//		System.out.println(list);

//		List<String> mutable = new ArrayList<>();
//		mutable.add("apple");
//		mutable.add("pear");
//		// 变为不可变集合:
//		List<String> immutable = Collections.unmodifiableList(mutable);
//		immutable.add("orange"); // UnsupportedOperationException!

//		List<String> mutable = new ArrayList<>();
//		mutable.add("apple");
//		mutable.add("pear");
//		// 变为不可变集合:
//		List<String> immutable = Collections.unmodifiableList(mutable);
//		mutable.add("orange");
//		System.out.println(immutable);

		List<String> mutable = new ArrayList<>();
		mutable.add("apple");
		mutable.add("pear");
		// 变为不可变集合:
		List<String> immutable = Collections.unmodifiableList(mutable);
		// 立刻扔掉mutable的引用:
		mutable = null;
		System.out.println(immutable);

	}

}
