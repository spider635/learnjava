package demo.regexp;

public class GeneralDemo {

	public static void main(String[] args) {

		String regex = "20\\d\\d";
		System.out.println("2019".matches(regex)); // true
		System.out.println("2100".matches(regex)); // false

	}

}
