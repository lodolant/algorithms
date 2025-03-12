import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String scanned;
			do {
				scanned = scanner.nextLine();
			} while (scanned != "");
		}
	}
}
