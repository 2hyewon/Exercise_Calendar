package Exercise.Calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal>";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		String prom = ">";

		while (true) {
			System.out.println("\n월을 입력하세요");
			System.out.print(prom);
			int month = scanner.nextInt();
			if (month == -1) {
				System.out.println("Seeya!");
				break;
			}
			cal.PrintCalendar(month);
		}
		scanner.close();

	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
