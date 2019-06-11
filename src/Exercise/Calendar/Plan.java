package Exercise.Calendar;

import java.text.ParseException;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Plan {
	public Plan() {
		planMap = new MultivaluedHashMap<Date, String>(); //생성자 호출시 초기화
	}
	Date date = new Date();
	MultivaluedMap<Date, String> planMap;
	
	public Date strDateToKey(String strDate) {
		Date sDate = null;
		try {
			sDate = new SimpleDateFormat("yyyyMMdd").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sDate;
	}
	
	public void PutPlan(String strDate, Scanner s) {
		System.out.println("wirte your schedule");
		String plan = s.nextLine();		
		Date sDate = strDateToKey(strDate);
		planMap.add(sDate, plan);
	}

	public void GetPlan(String strDate) {
		Date sDate = strDateToKey(strDate);
		System.out.println(planMap.get(sDate));
	}

	public void RemovePlan(String strDate) {
		Date sDate = strDateToKey(strDate);
		System.out.println(planMap.remove(sDate));
	}
	
}
