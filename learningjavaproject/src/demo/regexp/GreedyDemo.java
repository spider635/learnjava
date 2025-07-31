package demo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyDemo {

	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("(\\d+?)(0*)");
		Matcher matcher = pattern.matcher("1230000");
		if (matcher.matches()) {
			System.out.println("group1=" + matcher.group(1)); // "123"
			System.out.println("group2=" + matcher.group(2)); // "0000"
		}

	}

}
