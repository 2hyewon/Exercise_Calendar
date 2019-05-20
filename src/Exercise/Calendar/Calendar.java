package Exercise.Calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int GetMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void PrintSampleCalendar(int month) {
		if (month < 0 || month > 12) {
			System.out.println("1~12까지 입력해주세요.");
			return;
		} else {
			System.out.println("일  월  화  수  목  금");
			System.out.println("-------------------");
			System.out.println("1  2  3  4  5  6  7");
			System.out.println("8  9  10 11 12 13 14");
			System.out.println("15 16 17 18 19 20 21");
			System.out.println("22 23 24 25 26 27 28");
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println("29 30 31");
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				System.out.println("29 30");
			}
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		String prom = ">";

		while (true) {
			System.out.println("\n월을 입력하세요");
			System.out.print(prom);
			int month = scanner.nextInt();
			if(month == -1) {
				System.out.println("Seeya!");
				break;
			}
			cal.PrintSampleCalendar(month);
		}

//		while(true) {
//		System.out.println("월을 입력하세요.");
//		System.out.print("> ");
//		int month = scanner.nextInt();
//		if(month == -1) {
//			break;
//		}
//		if(month > 12) {
//			continue;
//		}
//		System.out.printf("%d월은 %d일까지 있습니다.\n",month,cal.GetMaxDaysOfMonth(month));
//		
//		}
//		
//		System.out.println("seeya!");
//		System.out.println("반복횟수를 입력하세요.");
//		int count = scanner.nextInt();
//		System.out.println("달을 입력하세요");
//		int[] month = new int[count];
//		for(int i=0; i<count; i++) {
//			month[i] = scanner.nextInt();			
//		}
//		for(int i=0; i<count; i++) {
//			int result = cal.GetMaxDaysOfMonth(month[i]);
//			System.out.printf("%d월은 %d일까지 있습니다.\n\n",month[i],result);
//		}
		// System.out.printf("%d월은 %d일까지 있습니다\n\n",month,result);
//		cal.PrintSampleCalendar();
		scanner.close();

	}

}
