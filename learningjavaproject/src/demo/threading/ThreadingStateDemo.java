package demo.threading;

public class ThreadingStateDemo {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(() -> {
			System.out.println("hello");
		});
		System.out.println("start");
		t.start(); // 启动t线程
		t.join(); // 此处main线程会等待t结束
		System.out.println("end");

	}

}
