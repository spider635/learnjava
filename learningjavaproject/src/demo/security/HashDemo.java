package demo.security;

import java.security.MessageDigest;
import java.util.HexFormat;

public class HashDemo {

	public static void main(String[] args) throws Exception {
//		哈希碰撞
		System.out.println("AaAaAa".hashCode()); // 0x7460e8c0
		System.out.println("BBAaBB".hashCode()); // 0x7460e8c0

		// 创建一个MessageDigest实例:
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 反复调用update输入数据:
		md.update("Hello".getBytes("UTF-8"));
		md.update("World".getBytes("UTF-8"));
		byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
		System.out.println(HexFormat.of().formatHex(result));

		// 创建一个MessageDigest实例:
		MessageDigest md1 = MessageDigest.getInstance("SHA-1");
		// 反复调用update输入数据:
		md1.update("Hello".getBytes("UTF-8"));
		md1.update("World".getBytes("UTF-8"));
		byte[] result1 = md1.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
		System.out.println(HexFormat.of().formatHex(result1));

	}

}
