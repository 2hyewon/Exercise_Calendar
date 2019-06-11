package Exercise.Calendar;

import java.util.Scanner;

public class Prompt {

//	public int parseDay(String weekday) {
//		switch (weekday) {
//		case "SU":
//			return 0;
//		case "MO":
//			return 1;
//		case "TU":
//			return 2;
//		case "WE":
//			return 3;
//		case "TH":
//			return 4;
//		case "FR":
//			return 5;
//		case "SA":
//			return 6;
//		}
//		return 0;
//	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		Plan plan = new Plan();
		String prom = "> ";

		cal.PrintCurrentCalendar();

		boolean isLoop = true;
		while (true) {
			System.out.println("\n\nSelect one : 1.input 2.get 3.remove 4.quit");
			System.out.print(prom);
			int selected = scanner.nextInt();

			System.out.println("\n input yyyymmdd");
			String strDate = scanner.next();
			scanner.nextLine();
			
			switch (selected) {
			case 1:
				plan.PutPlan(strDate, scanner);
				break;
			case 2:
				System.out.println("here's your schedule");
				System.out.print("-> ");
				plan.GetPlan(strDate);
				break;
			case 3:
				plan.RemovePlan(strDate);
				System.out.println(">>>> It's removed");
				break;
			case 4:
				isLoop = false;
				break;
			}
		}

//		while (true) {
//			System.out.println("\n연도를 입력하세요");
//			System.out.print("YEAR" + prom);
//			year = scanner.nextInt();
//			System.out.println("\n월을 입력하세요");
//			System.out.print("MONTH" + prom);
//			month = scanner.nextInt();
////			System.out.println("\n첫번째 요일 입력하세요. SU, MO, TU, WE, TH, FR, SA");
////			System.out.print("WEEKDAY" + prom);
////			String str_weekday = scanner.next();
////			weekday = parseDay(str_weekday);
//
//			if (month == -1) {
//				System.out.println("Seeya!");
//				break;
//			}
//			cal.PrintCalendar(year, month);
//		}
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
