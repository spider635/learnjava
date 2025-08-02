package demo.threading;

public class DeadLockDemo {
	public final Object lockA = new Object();
	public final Object lockB = new Object();
	public int value;
	public int another;

	public static void main(String[] args) {

	}

	public void add(int m) {
		synchronized (lockA) { // 获得lockA的锁
			this.value += m;
			synchronized (lockB) { // 获得lockB的锁
				this.another += m;
			} // 释放lockB的锁
		} // 释放lockA的锁
	}

	public void dec(int m) {
		synchronized (lockB) { // 获得lockB的锁
			this.another -= m;
			synchronized (lockA) { // 获得lockA的锁
				this.value -= m;
			} // 释放lockA的锁
		} // 释放lockB的锁
	}

}
