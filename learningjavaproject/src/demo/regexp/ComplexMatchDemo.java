package demo.regexp;

public class ComplexMatchDemo {

	public static void main(String[] args) {
		String re = "java|php";
		System.out.println("java".matches(re));
		System.out.println("php".matches(re));
		System.out.println("go".matches(re));

		String re1 = "learn\\s(java|php|go)";
		System.out.println("learn java".matches(re1));
		System.out.println("learn Java".matches(re1));
		System.out.println("learn php".matches(re1));
		System.out.println("learn Go".matches(re1));
	}

}
