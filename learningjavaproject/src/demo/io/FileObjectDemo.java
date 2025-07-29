package demo.io;

import java.io.File;

public class FileObjectDemo {

	public static void main(String[] args) {
		// 指定要遍历的目录（例如：C:\Test）
		File rootDir = new File("C:\\Windows");
		printDirectoryTree(rootDir, 0);
	}

	/**
	 * 递归打印目录树结构
	 * 
	 * @param dir   当前目录
	 * @param level 当前层级（用于缩进）
	 */
	public static void printDirectoryTree(File dir, int level) {
		// 缩进字符串（每层缩进4个空格）
		String indent = " ".repeat(level * 4);

		// 打印当前目录名
		System.out.println(indent + "📁 " + dir.getName());

		File[] files = dir.listFiles();
		if (files == null) {
			return; // 无权限访问时返回
		}

		for (File file : files) {
			if (file.isDirectory()) {
				// 递归处理子目录
				printDirectoryTree(file, level + 1);
			} else {
				// 打印文件名
				System.out.println(indent + "    📄 " + file.getName());
			}
		}
	}
}