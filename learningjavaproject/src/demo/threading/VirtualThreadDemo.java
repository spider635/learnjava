package demo.threading;

import java.util.concurrent.ThreadFactory;

public class VirtualThreadDemo {

	public static void main(String[] args) throws Exception {

		// 传入Runnable实例并立刻运行:
		Thread vt = Thread.startVirtualThread(() -> {
			System.out.println("Start virtual thread...");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("End virtual thread.");
		});
		vt.start(); // needed?

		// 创建VirtualThread:
		Thread vt1 = Thread.ofVirtual().unstarted(() -> {
			System.out.println("Start virtual thread...");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("End virtual thread.");
		});
		// 运行:
		vt1.start();

		// 创建ThreadFactory:
		ThreadFactory tf = Thread.ofVirtual().factory();
		// 创建VirtualThread:
		Thread vt2 = tf.newThread(() -> {
			System.out.println("Start virtual thread...");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("End virtual thread.");
		});
		// 运行:
		vt2.start();

	}

}
