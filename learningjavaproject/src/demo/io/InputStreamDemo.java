package demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws IOException {

		String s;
		try (InputStream input = new FileInputStream("setting.properties")) {
			int n;
			StringBuilder sb = new StringBuilder();
			while ((n = input.read()) != -1) {
				sb.append((char) n);
			}
			s = sb.toString();
		}
		System.out.println(s);

	}

}
