package collection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String f = "setting.properties";
		var fis = new java.io.FileInputStream(f);
		var fos = new java.io.FileOutputStream(f, true);
		Properties props = new Properties();
		props.load(fis);

		String filepath = props.getProperty("last_open_file");
		String interval = props.getProperty("auto_save_interval", "120");
		System.out.println(filepath);
		System.out.println(interval);

		props.setProperty("url", "http://www.liaoxuefeng.com");
		props.setProperty("language", "Java");
		props.store(fos, "这是写入的properties注释");

	}

}
