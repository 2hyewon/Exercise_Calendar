package Exercise.Calendar;

import java.io.IOException;
import java.util.Scanner;

public class Prompt {

private static final String Scanner = null;

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

	public void runPrompt() throws IOException, ClassNotFoundException {
		Plan plan = new Plan();
		Calendar cal = new Calendar();
		String prom = "> ";
		cal.PrintCurrentCalendar();

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("\n\nSelect one : 1.input 2.get 3.getAll 4.remove 5.quit");
			System.out.print(prom);
			Scanner scanner = new Scanner(System.in);
			int selected = scanner.nextInt();
			
			switch (selected) {
			case 1:
				plan.RegisterPlan();
				break;
			case 2:
				plan.GetPlan();
				break;
			case 3:
				plan.GetAllPlan();
				break;
			case 4:
				plan.RemovePlan();
				break;
			case 5:
				isLoop = false;
				break;
			}
		}
	}
	
	public void runPromptWithoutCal() throws IOException, ClassNotFoundException {
		Plan plan = new Plan();
		String prom = "> ";
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("\n\nSelect one : 1.input 2.get 3.remove 4.quit");
			System.out.print(prom);
			Scanner scanner = new Scanner(System.in);
			int selected = scanner.nextInt();
			
			switch (selected) {
			case 1:
				plan.RegisterPlan();
				break;
			case 2:
				plan.GetPlan();
				break;
			case 3:
				plan.RemovePlan();
				break;
			case 4:
				isLoop = false;
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
