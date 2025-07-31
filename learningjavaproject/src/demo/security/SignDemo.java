package demo.security;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.HexFormat;

public class SignDemo {

	public static void main(String[] args) throws Exception {

		// 生成RSA公钥/私钥:
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair kp = kpGen.generateKeyPair();
		PrivateKey sk = kp.getPrivate();
		PublicKey pk = kp.getPublic();

		// 待签名的消息:
		byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

		// 用私钥签名:
		Signature s = Signature.getInstance("SHA1withRSA");
		s.initSign(sk);
		s.update(message);
		byte[] signed = s.sign();
		System.out.println("signature: " + HexFormat.of().formatHex(signed));

		// 用公钥验证:
		Signature v = Signature.getInstance("SHA1withRSA");
		v.initVerify(pk);
		v.update(message);
		boolean valid = v.verify(signed);
		System.out.println("valid? " + valid);
	}
}