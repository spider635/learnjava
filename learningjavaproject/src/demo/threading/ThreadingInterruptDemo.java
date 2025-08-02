package demo.threading;

public class ThreadingInterruptDemo {

	public static void main(String[] args) throws Exception {
//		Thread t = new MyThread1();
//		t.start();
//		Thread.sleep(1); // 暂停1毫秒
//		t.interrupt(); // 中断t线程
//		t.join(); // 等待t线程结束
//		System.out.println("end");

//		System.out.println("-------------------------------------");
//
//		Thread t = new MyThread2();
//		t.start();
//		Thread.sleep(1000);
//		t.interrupt(); // 中断t线程
//		t.join(); // 等待t线程结束
//		System.out.println("end");

		HelloThread t = new HelloThread();
		t.start();
		Thread.sleep(1);
		t.running = false; // 标志位置为false

	}

}

class MyThread1 extends Thread {
	public void run() {
		int n = 0;
		while (!isInterrupted()) {
			n++;
			System.out.println(n + " hello!");
		}
	}
}

class MyThread2 extends Thread {
	public void run() {
		Thread hello = new HelloThread();
		hello.start(); // 启动hello线程
		try {
			hello.join(); // 等待hello线程结束
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}
		hello.interrupt();
	}
}

class HelloThread extends Thread {
	public volatile boolean running = true;

	public void run() {
		int n = 0;
		while (running) {
			n++;
			System.out.println(n + " hello!");
		}
		System.out.println("end!");
	}
}
