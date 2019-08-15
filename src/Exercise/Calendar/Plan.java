package Exercise.Calendar;

import java.util.List;
//import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Plan {
	private static final String SAVE_PATH = "src" + File.separator + "Plan" + File.separator + "calendar_plan.dat";
	private static final String SAVE_PATH2 = "src" + File.separator + "Plan" + File.separator + "temp.dat";
	Path originPath = Paths.get(SAVE_PATH);
	Path tempPath = Paths.get(SAVE_PATH2);
	File planFile = new File(SAVE_PATH);
	File tempFile = new File(SAVE_PATH2);
	String userDate;
	MultivaluedMap<String, String> planMap;

	public Plan() {
		planMap = new MultivaluedHashMap<String, String>(); // 생성자 호출시 초기화
		init();
	}
	public void init() {
		if (!planFile.exists()) {
			return;
		}
		Scanner scanner;
		try {
			scanner = new Scanner(planFile);
			while (scanner.hasNext()) {
				String fileALine = scanner.nextLine();
				String[] words = fileALine.split(",", 2);
				String fileDate = words[0];
				String filePlan = words[1];
				PlanItem p = new PlanItem(fileDate, filePlan);
				planMap.add(p.getDate(fileDate), filePlan);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void askDate() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n input yyyymmdd");
		String userDate = scanner.next();
		this.userDate = userDate;
	}

	public void RegisterPlan() { // Register a new plan
		askDate();
		System.out.println("wirte your schedule");
		Scanner scanner = new Scanner(System.in);
		String userPlan = scanner.nextLine();
		userPlan = userPlan.trim();
		PlanItem p = new PlanItem(userDate, userPlan);
		p.getDate(userDate);
		planMap.add(p.getDate(userDate), userPlan);
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(planFile, true)));
			pw.println(p.getFileLine());
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// scanner.close();
		// It causes ‘Exception in thread “main” java.util.NoSuchElementException’ error
	}

	public void GetPlan() { // Get registered plans
		askDate();
		PlanItem p = new PlanItem();
		System.out.println("here's your schedule");
		System.out.print("-> ");
		System.out.print(planMap.get(p.getDate(userDate)));

		// Q. Why It print address value of added input on same key and only works
		// properly when it's rebooted?
		// A. It occurs because reference value was passed when PlanItem.getDate() was
		// called. So I added a line on PlanItem.getDate() to get the value from
		// reference one.
		// Q. Still print same way.. but It works on next run not after reboot anymore.
		// A. there is two way to solve it.
		// 1. There was a planMap.add(p.getDate(userDate), p) line in RegisterPlan().
		// Which is wrong value(Object p) was added. So It got fixed.
		// 2. Move the line 'Plan plan = new Plan();' in prompt select loop so that
		// initialize every time when the select number is selected. Which means,
		// execute planMap.add(p.getDate(fileDate),filePlan); every time.
	}
	public void GetAllPlan() {
		PlanItem p = new PlanItem(userDate);
		Set<String> keys = planMap.keySet();
		int num = 1;
		for(String k : keys) {
		System.out.print(num+". "+k+" - ");
		System.out.println(planMap.get(k));
		num++;
		}
	}

	public void RemovePlan() { // remove a plan
		askDate();
		PlanItem p = new PlanItem(userDate);
		boolean keyExists = planMap.containsKey(p.getDate(userDate));
		boolean valueExists;
		String line = null;
		String valueLine = null;
		boolean isLoop = true;

		while (isLoop) {
			if (!keyExists) {
				System.out.println("wrong date");
				break;
			}
			if (keyExists) {
				System.out.print(planMap.get(p.getDate(userDate)));
				System.out.println("\nWrite down the plan you want to delete");

				Scanner scanner = new Scanner(System.in);
				line = scanner.nextLine();

				// why does 'planMap.containsvalue' not work?
				// Set<String> keys = planMap.keySet(); 'for(String k : keys)' <- It is
				// available with this line
				List<String> itemsWithKey = (List<String>) planMap.get(p.getDate(userDate));
				valueExists = itemsWithKey.contains(line);

				if (valueExists) {
					System.out.println("Complete");
					valueLine = line;
					break;
				} else {
					System.out.println("\n Wrong value");
					System.out.println("\n Select one : 1.Try again 2.Quit");
					int selected = scanner.nextInt();
					scanner.nextLine();
					switch (selected) {
					case 1:
//						System.out.print("\n" + planMap.get(p.getDate(userDate)));
//						System.out.println("\nWrite down the plan you want to delete");
//						scanner.nextLine();
//						line = scanner.nextLine();
						break; // go to while(isLoop) 
					case 2:
						isLoop = false;
					}
				}
			}
		}

		String lineToRemove = p.getDate(userDate) + "," + valueLine;

		StringBuffer newContent = new StringBuffer();

		try {
			BufferedReader br = new BufferedReader(new FileReader(planFile)); // planFile has the path of the'calendar_plan.dat'
																				
			try {
				while ((line = br.readLine()) != null) {
					if (!line.trim().equals(lineToRemove.trim())) {
						newContent.append(line);
						newContent.append("\n");
					}
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				PrintWriter replace = new PrintWriter(new BufferedWriter(new FileWriter(tempFile, true))); 
				// tempFile has the path of the'temp.dat', In 'FileWriter(PATH, true)' the true(second argument) means append mode is on in the file 																			
				replace.write(newContent.toString());
				Files.move(tempPath, originPath, REPLACE_EXISTING); // I solve the problem that only temFile's left and no line's removed by changing the paths' position.
				replace.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planMap.clear(); 
		// To get the removed map according to the above result from select number "2.get", clear all of the mappings from planMap
		init(); // and rewrite the result in the map
	}
}
