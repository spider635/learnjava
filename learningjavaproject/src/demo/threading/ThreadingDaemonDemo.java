package demo.threading;

public class ThreadingDaemonDemo {
	public static void main(String[] args) {
		// 创建一个守护线程
		Thread daemonThread = new Thread(() -> {
			while (true) {
				try {
					System.out.println("守护线程正在运行...");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// 设置为守护线程
		daemonThread.setDaemon(true);
		daemonThread.start();

		// 主线程（用户线程）执行
		System.out.println("主线程开始执行...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主线程执行完毕，程序将退出");

		// 当主线程结束后，守护线程也会自动终止
	}
}