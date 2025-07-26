package learningjavaproject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) {
		try {
			Person p = new Person("Xiao Ming");
			System.out.println(p.getName()); // "Xiao Ming"
			Class<?> c = p.getClass();
			Field f = c.getDeclaredField("name");
			f.setAccessible(true);
			f.set(p, "Xiao Hong");
			System.out.println(p.getName()); // "Xiao Hong"

			// String对象:
			String s = "Hello world";
			// 获取String substring(int)方法，参数为int:
			Method m = String.class.getMethod("substring", int.class);
			// 在s对象上调用该方法并获取结果:
			String r = (String) m.invoke(s, 6);
			// 打印调用结果:
			System.out.println(r); // "world"

			Person pp = new Person();
			System.out.println(pp.getName());
			Method mm = pp.getClass().getDeclaredMethod("setName", String.class);
			mm.setAccessible(true);
			mm.invoke(pp, "Bob");
			System.out.println(pp.getName());

		} catch (IllegalAccessException | NoSuchFieldException e) {
			System.out.println(e);
		} catch (InvocationTargetException | NoSuchMethodException e) {
			System.out.println(e);
		}

	}
}

class Person {
	private String name;

	public Person() {
		setName("");
	}

	public Person(String name) {
		setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
