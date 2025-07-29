package demo.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		try (Reader reader = new FileReader("readme.txt")) { // 字符编码是???
			for (;;) {
				int n = reader.read(); // 反复调用read()方法，直到返回-1
				if (n == -1) {
					break;
				}
				System.out.println((char) n); // 打印char
			}
		}

	}

}
