package collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		List<Message> received = List.of(new Message(1, "Hello!"), new Message(2, "发工资了吗？"), new Message(2, "发工资了吗？"),
				new Message(3, "去哪吃饭？"), new Message(3, "去哪吃饭？"), new Message(4, "Bye"));
		List<Message> displayMessages = process(received);
		for (Message message : displayMessages) {
			System.out.println(message.text);
		}
	}

	static List<Message> process(List<Message> received) {
		// 使用LinkedHashSet保持插入顺序
		Set<Integer> seenSequences = new LinkedHashSet<>();
		List<Message> result = new ArrayList<>();

		for (Message message : received) {
			if (seenSequences.add(message.sequence)) {
				result.add(message);
			}
		}

		return result;
	}
}

class Message {
	public final int sequence;
	public final String text;

	public Message(int sequence, String text) {
		this.sequence = sequence;
		this.text = text;
	}
}