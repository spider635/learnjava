package demo.regexp;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplaceDemo {

	public static void main(String[] args) {

		String s = "the quick brown fox jumps over the lazy dog.";
		Pattern p = Pattern.compile("\\wo\\w");
		Matcher m = p.matcher(s);
		while (m.find()) {
			String sub = s.substring(m.start(), m.end());
			System.out.println(sub);
		}

		String s1 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
		String r = s1.replaceAll("\\s+", " ");
		System.out.println(r); // "The quick brown fox jumps over the lazy dog."

		String s2 = "the quick brown fox jumps over the lazy dog.";
		String r2 = s2.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
		System.out.println(r2);

		// 请编写一个简单的模板引擎，利用正则表达式实现这个功能。
		System.out.println("请编写一个简单的模板引擎，利用正则表达式实现这个功能。");
		String ss = "Hello, ${name}! You are learning ${lang}!";
		Map<String, String> map = new HashMap<>();
		map.put("name", "Bob");
		map.put("lang", "Java");

		System.out.println(replaceTemplate(ss, map));

	}

	public static String replaceTemplate(String s, Map<String, String> map) {
		// 使用正则表达式匹配 ${...} 模式
		Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");
		Matcher matcher = pattern.matcher(s);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String key = matcher.group(1);
			String replacement = map.getOrDefault(key, "");
			matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
		}
		matcher.appendTail(sb);

		return sb.toString();

	}

}
