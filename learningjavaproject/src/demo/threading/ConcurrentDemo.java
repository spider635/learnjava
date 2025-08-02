package demo.threading;

// 使用Concurrent集合

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentDemo {

	public static void main(String[] args) {

		Map<String, String> map = new ConcurrentHashMap<>();
		// 在不同的线程读写:
		map.put("A", "1");
		map.put("B", "2");
		map.get("A");

//		Map unsafeMap = new HashMap();
//		Map threadSafeMap = Collections.synchronizedMap(unsafeMap);

	}

}

class TaskQueue2 {
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	private Queue<String> queue = new LinkedList<>();

	public void addTask(String s) {
		lock.lock();
		try {
			queue.add(s);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public String getTask() throws Exception {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				condition.await();
			}
			return queue.remove();
		} finally {
			lock.unlock();
		}
	}
}
