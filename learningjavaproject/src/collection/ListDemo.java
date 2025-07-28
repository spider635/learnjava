package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * List是一种有序列表.
 * 需要增删元素的有序列表，我们使用最多的是ArrayList
 * 
 * ArrayList（动态数组） 通过数组来实现List接口
 * LinkedList 通过“链表”实现List接口
 * 
 */

public class ListDemo {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String unused = """
				List<String> list = new ArrayList<>();
				list.add("apple"); // size=1
				list.add("pear"); // size=2
				list.add("apple"); // 允许重复添加元素，size=3
				System.out.println(list.size());

				// 使用Iterator遍历List代码如下
				List<String> list1 = List.of("apple", "pear", "banana");
				for (Iterator<String> it = list1.iterator(); it.hasNext();) {
					String s = it.next();
					System.out.println(s);
				}
				for (String s : list1) {
					System.out.println(s);
				}

				// List和Array转换
				System.out.println("List和Array转换");
				Object[] array = list.toArray();
				for (Object s : array) {
					System.out.println(s);
				}

				List<Integer> list2 = List.of(12, 34, 56);
				Integer[] array1 = list2.toArray(new Integer[3]);
				for (Integer n : array1) {
					System.out.println(n);
				}
				""";

//		// 给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字
//		System.out.println("给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字");
//
//		// 构造从start到end的序列：
//		final int start = 10;
//		final int end = 20;
//		List<Integer> list = new ArrayList<>();
//		for (int i = start; i <= end; i++) {
//			list.add(i);
//		}
//		// 随机删除List中的一个元素:
//		int removed = list.remove((int) (Math.random() * list.size()));
//		int found = findMissingNumber(start, end, list);
//		System.out.println(list.toString());
//		System.out.println("missing number: " + found);
//		System.out.println(removed == found ? "测试成功" : "测试失败");

		// 构造从start到end的序列：
		final int start = 10;
		final int end = 20;
		List<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		// 洗牌算法shuffle可以随机交换List中的元素位置:
		Collections.shuffle(list);
		// 随机删除List中的一个元素:
		int removed = list.remove((int) (Math.random() * list.size()));
		int found = findMissingNumber(start, end, list);
		System.out.println(list.toString());
		System.out.println("missing number: " + found);
		System.out.println(removed == found ? "测试成功" : "测试失败");

	}

	static int findMissingNumber(int start, int end, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (!(list.contains(start + i))) {
				return start + i;
			}
		}
		return 0;
	}

}
