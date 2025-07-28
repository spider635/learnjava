package collection;

import java.util.Map;
import java.util.TreeMap;

// 有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap。
// TreeMap的Key是排序的。

public class TreeMapDemo {

	public static void main(String[] args) {
		Map<String, Integer> map = new TreeMap<>();
		map.put("orange", 1);
		map.put("apple", 2);
		map.put("pear", 3);
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		// apple, orange, pear

	}

}
