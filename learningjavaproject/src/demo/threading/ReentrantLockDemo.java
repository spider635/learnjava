package demo.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	public static void main(String[] args) {

	}

}

class Counter1 {
	private final Lock lock = new ReentrantLock();
	private int count;

	public void add(int n) {
		lock.lock();
		try {
			count += n;
			System.out.println(count);
		} finally {
			lock.unlock();
		}
	}
}
