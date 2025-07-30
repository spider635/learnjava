package demo.unittest;

public class JunitTestDemo {

	public static void main(String[] args) {
		if (Factorial.fact(10) == 3628800) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

}

class Factorial {
	public static long fact(long n) {
		long r = 1;
		for (long i = 1; i <= n; i++) {
			r = r * i;
		}
		return r;
	}
}
