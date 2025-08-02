package demo.threading;

public class NewThreadDemo {

	public static void main(String[] args) {

		System.out.println("main start...");
		Thread t = new Thread() {
			public void run() {
				System.out.println("thread run...");
				System.out.println("thread end.");
			}
		};
		t.start();
		System.out.println("main end...");

	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("start new thread!");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("start new thread!");
	}
}
