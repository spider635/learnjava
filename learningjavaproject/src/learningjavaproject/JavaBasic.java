package learningjavaproject;
import java.util.Scanner;

public class JavaBasic {
	public static void main(String[] args) {	
		var scanner = new Scanner(System.in);
		System.out.print("Input Xiaoming's last score: ");
		int last_score = scanner.nextInt();
		System.out.print("Input Xiaoming's current score: ");
        int current_score = scanner.nextInt();
        double raise_score = (double)(current_score - last_score) / last_score * 100;
        System.out.printf("\n Xiaoming's score raised: %.2f%%", raise_score);
        scanner.close();
	}
}
