package demo.security;

import java.util.HexFormat;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacDemo {

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
		SecretKey key = keyGen.generateKey();
		// 打印随机生成的key:
		byte[] skey = key.getEncoded();
		System.out.println(HexFormat.of().formatHex(skey));

		Mac mac = Mac.getInstance("HmacMD5");
		mac.init(key);
		mac.update("HelloWorld".getBytes("UTF-8"));
		byte[] result = mac.doFinal();
		System.out.println(HexFormat.of().formatHex(result));

		byte[] hkey = HexFormat.of().parseHex("b648ee779d658c420420d86291ec70f5" + "cf97521c740330972697a8fad0b55f5c"
				+ "5a7924e4afa99d8c5883e07d7c3f9ed0" + "76aa544d25ed2f5ceea59dcc122babc8");
		SecretKey key1 = new SecretKeySpec(hkey, "HmacMD5");
		Mac mac1 = Mac.getInstance("HmacMD5");
		mac1.init(key1);
		mac1.update("HelloWorld".getBytes("UTF-8"));
		byte[] result1 = mac1.doFinal();
		System.out.println(HexFormat.of().formatHex(result1)); // 4af40be7864efaae1473a4c601b650ae

	}

}
