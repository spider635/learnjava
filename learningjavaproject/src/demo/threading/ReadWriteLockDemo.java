package demo.threading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 只允许一个线程写入（其他线程既不能写入也不能读取）；
// 没有写入时，多个线程允许同时读（提高性能）。

public class ReadWriteLockDemo {

	public static void main(String[] args) {

	}

}

class Counter2 {
	private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
	// 注意: 一对读锁和写锁必须从同一个rwlock获取:
	private final Lock rlock = rwlock.readLock();
	private final Lock wlock = rwlock.writeLock();
	private int[] counts = new int[10];

	public void inc(int index) {
		wlock.lock(); // 加写锁
		try {
			counts[index] += 1;
		} finally {
			wlock.unlock(); // 释放写锁
		}
	}

	public int[] get() {
		rlock.lock(); // 加读锁
		try {
			return Arrays.copyOf(counts, counts.length);
		} finally {
			rlock.unlock(); // 释放读锁
		}
	}
}
