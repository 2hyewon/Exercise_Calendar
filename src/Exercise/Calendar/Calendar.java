package Exercise.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	Date date = new Date();
	//ArrayList<String> list = new ArrayList<String>();

	public Calendar() {
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else
			return false;
	}

	public int GetMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else
			return MAX_DAYS[month - 1];
	}

	public int GetFirstDayOfMonth(int year, int month) {

		int sYear = 1970;
		final int S_FIRSTDAY = 4; // 1st/Jan/1970 = Thursday
		int firstDay = 0;
		int day_count = 0;

		for (int i = sYear; i < year; i++) {
			day_count += isLeapYear(i) ? 366 : 365;
		}
		for (int i = 1; i < month; i++) {
			day_count += GetMaxDayOfMonth(year, i);
		}

		return firstDay = (day_count + S_FIRSTDAY) % 7;
	}

	public void PrintCurrentCalendar() { //Print today's calendar with a dot for today
		String strYear = new SimpleDateFormat("yyyy").format(date);
		String strMonth = new SimpleDateFormat("MM").format(date);
		String strDay = new SimpleDateFormat("dd").format(date);
		int intYear = Integer.parseInt(strYear);
		int intMonth = Integer.parseInt(strMonth);
		int intDay = Integer.parseInt(strDay);
		PrintCalendar(intYear, intMonth, intDay);
	}

	public void PrintCalendar(int year, int month, int day) {

		int firstDay = GetFirstDayOfMonth(year, month);

		if (month < 0 || month > 12) {
			System.out.println("1~12까지 입력해주세요.");
			return;
		} else {
			int max = GetMaxDayOfMonth(year, month);
			int count = 0;
			int dayCount = 0;
			System.out.printf(" %4d  %3d월\n", year, month);
			System.out.println(" SU MO TU WE TH FR SA");
			System.out.println("------------------------");

			// print blank space before the day 1
			for (int i = 0; i < firstDay; i++) {
				System.out.printf("   ");
			}
			for (int i = 1; i <= max; i++) {
				System.out.printf("%3d", i);
				if ((i + firstDay) % 7 == 0) {
					System.out.println();
					if(count != 0) {
						for (int k = 1; k<=7; k++) {
							dayCount++;
							if(dayCount == day) {
								System.out.print(" == ");
							}
							System.out.printf("   ");
						}
						System.out.println();
					}
					else if(count == 0) {
						for (int j = 0; j < firstDay; j++) {
							System.out.printf("   ");
						}
						for (int k = 1; k<=7-firstDay; k++) {
							dayCount++;
							if (dayCount == day) {
								System.out.println(" . ");
							}
							System.out.printf("   ");
							if((k+firstDay) % 7 == 0) {
								System.out.println();
								count++;
							}
						}
					}
				}
			}

		}
	}

}
