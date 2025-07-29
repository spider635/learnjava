package demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	public static void main(String[] args) throws IOException {
		try (ZipInputStream zip = new ZipInputStream(new FileInputStream("readme.zip"))) {
			ZipEntry entry = null;
			while ((entry = zip.getNextEntry()) != null) {
				String name = entry.getName();
				System.out.println(name);
				if (!entry.isDirectory()) {
					int n;
					while ((n = zip.read()) != -1) {
						System.out.print((char) n);
					}
				}
			}
		}

		try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("readme.zip"))) {
			File[] files = new File[] { new File("readme.txt"), new File("setting.properties") };
			for (File file : files) {
				zip.putNextEntry(new ZipEntry(file.getName()));
				zip.write(Files.readAllBytes(file.toPath()));
				zip.closeEntry();
			}
		}

	}
}
