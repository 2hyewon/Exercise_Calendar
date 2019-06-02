package Exercise.Calendar;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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
//		int allDaysOfYears = (year-1)*365; // calculate all the days till last year (from 1/1/1 to the year before inputed)
//		int allLeapDaysOfYears = 0; // calculate all leap days (from 1/1/1 to the year inputed)
//		int allDaysOfThisYear = 0; // calculate all days of this year
//		int firstDay = 0; // define the first day of the month
//		
//		if(month>2) {
//			allLeapDaysOfYears = (year/4) - (year/100) + (year/400);
//		}
//		else {
//			allLeapDaysOfYears = (((year-1)/4) - ((year-1)/100) + ((year-1)/400));
//		}
//		
//		for(int i=0; i<month-1; i++) {
//			allDaysOfThisYear += MAX_DAYS[i];
//		}
//		
//		// get it all together and find remainder 
//		firstDay = (allDaysOfYears+allLeapDaysOfYears+allDaysOfThisYear)%7;
		
		int sYear = 1970;
		final int S_FIRSTDAY = 4; // 1st/Jan/1970 = Thursday
		int firstDay = 0;
		int day_count = 0;
		
		for(int i = sYear; i<year; i++) {
			day_count += isLeapYear(i) ? 366 : 365;
		}
		for(int i = 1; i<month; i++) {
			day_count += GetMaxDayOfMonth(year,i);
		}
		
		return firstDay = (day_count+S_FIRSTDAY)%7;
		
		//return firstDay;
	}

	public void PrintCalendar(int year, int month) {
		
		//get weekday automatically
//		int firstDay = GetFirstDayOfMonth(year,month) + 1; // since 1/1/1 is Monday, plus 1
		int firstDay = GetFirstDayOfMonth(year,month);
		
		if (month < 0 || month > 12) {
			System.out.println("1~12까지 입력해주세요.");
			return;
		} else {
			int max = GetMaxDayOfMonth(year, month);
			System.out.printf(" %4d  %3d월\n", year, month);
			System.out.println(" SU MO TU WE TH FR SA");
			System.out.println("------------------------");
			
			//print blank space before the day 1
			for (int i = 0; i < firstDay; i++) {
				System.out.printf("   ");
			}
			for (int i = 1; i <= max; i++) {
				System.out.printf("%3d",i);
				if ((i+firstDay) % 7 == 0) {
					System.out.println();
				}
			}

		}
	}

}
