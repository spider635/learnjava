package demo.security;

import java.security.MessageDigest;
import java.security.Security;
import java.util.HexFormat;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BouncyCastleDemo {

	public static void main(String[] args) throws Exception {
		// 注册BouncyCastle:
		Security.addProvider(new BouncyCastleProvider());
		// 按名称正常调用:
		MessageDigest md = MessageDigest.getInstance("RipeMD160");
		md.update("HelloWorld".getBytes("UTF-8"));
		byte[] result = md.digest();
		System.out.println(HexFormat.of().formatHex(result));
	}

}
