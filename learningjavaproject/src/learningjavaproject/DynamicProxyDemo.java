package learningjavaproject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

	public static void main(String[] args) {
		// 实现接口的方法调用
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method);
				if (method.getName().equals("morning")) {
					System.out.println("Good morning, " + args[0]);
				}
				return null;
			}
		};
		HelloWorld hw = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(), // 传入ClassLoader
				new Class[] { HelloWorld.class }, // 传入要实现的接口
				handler); // 传入处理调用方法的InvocationHandler
		hw.morning("Bob");
	}
}

interface HelloWorld {
	void morning(String name);
}
