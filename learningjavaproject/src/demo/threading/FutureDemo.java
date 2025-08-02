package demo.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		// 定义任务:
		Callable<String> task1 = new Task1();
		// 提交任务并获得Future:
		Future<String> future = executor.submit(task1);
		// 从Future获取异步执行返回的结果:
		String result = future.get(); // 可能阻塞

		System.out.println("result is: " + result);

	}

}

class Task1 implements Callable<String> {
	public String call() throws Exception {
		Thread.sleep(1000);
		return "I am Task1";
	}
}