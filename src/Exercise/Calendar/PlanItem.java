package Exercise.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

public class PlanItem {
	String userDate; 
	String userPlan;
	public PlanItem(String userDate, String userPlan) {
		this.userDate = userDate;
		this.userPlan = userPlan;
	}
	public PlanItem(String userDate) {
		this.userDate = userDate;
	}
	public PlanItem() {
		
	}
	
	public String getFileLine() {
		return keyDateToStr(userDate) + "," + userPlan; 
	}
	

	public Date strDateToKey(String userDate) { // Convert String object(user input) into Date object in specific form
		Date keyDate = new Date();
		try {
			keyDate = new SimpleDateFormat("yyyyMMdd").parse(userDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyDate;
	}

	public String keyDateToStr(String userDate) { // Convert the specified Date object into String object (It means the way the date have has transformed)
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		String strdate = transFormat.format(strDateToKey(userDate));
		return strdate;
	}
	
	public String getDate(String userDate) {
		String key = keyDateToStr(userDate); // With this line, solve the problem (Why It print address value of added input on same key and only works properly when it's rebooted?) a little, It works properly at next run.
		return key;
	}

}
