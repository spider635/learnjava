package demo.threading;

//Thread
public class ThreadLocalDemo {
	static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();

	public static void main(String[] args) throws Exception {
		log("start main...");
		new Thread(() -> {
			log("run task...");
		}).start();
		new Thread(() -> {
			log("print...");
		}).start();
		log("end main.");
	}

	static void log(String s) {
		System.out.println(Thread.currentThread().getName() + ": " + s);
	}

	public static void processUser(User user) {
		try {
			threadLocalUser.set(user);
			step1();
			step2();
			log("hello world");
		} finally {
			threadLocalUser.remove();
		}
	}

	public static void step1() {
		User u = threadLocalUser.get();
		System.out.println(u);
//	    log();
//	    printUser();
	}

	public static void step2() {
		User u = threadLocalUser.get();
		System.out.println(u);
//	    checkUser(u.id);
	}

}

class User {

}
