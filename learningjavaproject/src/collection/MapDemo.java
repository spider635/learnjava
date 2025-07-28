package collection;

import java.util.HashMap;
import java.util.Map;

// Map也是一个接口，最常用的实现类是HashMap

public class MapDemo {

	public static void main(String[] args) {
		Student s = new Student("Xiao Ming", 99);
		Map<String, Student> map = new HashMap<>();
		map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
		map.put("Xiao Hong", new Student("Xiao Hong", 199));
		map.put("Xiao Yan", new Student("Xiao Yan", 299));
		Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
		System.out.println(target == s); // true，同一个实例
		System.out.println(target.score); // 99
		System.out.println("-----------------------");
		System.out.println(map.containsKey("Xiao Ming"));
		System.out.println("-----------------------");

		Student another = map.get("Bob"); // 通过另一个key查找
		System.out.println(another); // 未找到返回null

		for (String ss : map.keySet()) {
			System.out.print(ss);

		}

		System.out.println("\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String key1 = "a";
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put(key1, 123);

		String key2 = new String("a");
		System.out.println(mapa.get(key2)); // 123

		System.out.println(key1 == key2); // false
		System.out.println(key1.equals(key2)); // true
	}

}

class Student {
	public String name;
	public int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}