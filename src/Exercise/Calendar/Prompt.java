package Exercise.Calendar;

import java.util.Scanner;

public class Prompt {

	public int parseDay(String weekday) {
		switch (weekday) {
		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		}
		return 0;
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		String prom = "> ";
		int year = 2000;
		int month = 1;
		int weekday = 0;

		while (true) {
			System.out.println("\n연도를 입력하세요");
			System.out.print("YEAR" + prom);
			year = scanner.nextInt();
			System.out.println("\n월을 입력하세요");
			System.out.print("MONTH" + prom);
			month = scanner.nextInt();
			System.out.println("\n첫번째 요일 입력하세요. SU, MO, TU, WE, TH, FR, SA");
			System.out.print("WEEKDAY" + prom);
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);

			if (month == -1) {
				System.out.println("Seeya!");
				break;
			}
			cal.PrintCalendar(year, month, weekday);
		}
		scanner.close();

	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
