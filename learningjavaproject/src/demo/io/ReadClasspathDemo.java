package demo.io;

import java.io.IOException;
import java.io.InputStream;

public class ReadClasspathDemo {

	public static void main(String[] args) throws IOException {

		try (InputStream input = ReadClasspathDemo.class.getResourceAsStream("/default.properties")) {
			if (input != null) {
				// TODO:
			}
		}

	}

}
