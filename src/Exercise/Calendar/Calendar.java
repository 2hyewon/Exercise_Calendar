package Exercise.Calendar;


public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int GetMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void PrintCalendar(int month) {
		if (month < 0 || month > 12) {
			System.out.println("1~12까지 입력해주세요.");
			return;
		} else {
			int max = GetMaxDaysOfMonth(month);
			System.out.printf("   %3d월\n",month);
			System.out.println("  일  월  화  수  목  금");
			System.out.println("-----------------------");
			for(int i = 1; i <= max; i++) {
				System.out.printf("%3d", i);
				if(i%7==0) {
					System.out.println();
				}
			}
				
//			System.out.println("1  2  3  4  5  6  7");
//			System.out.println("8  9  10 11 12 13 14");
//			System.out.println("15 16 17 18 19 20 21");
//			System.out.println("22 23 24 25 26 27 28");
//			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
//				System.out.println("29 30 31");
//			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
//				System.out.println("29 30");
//			}
		}
	}

}
