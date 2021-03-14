package com.sda.kth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ToDoListCF {
	static String constantString = "";

	public static int ordinalIndexOf(String str, String substr, int n) {
		int pos = -1;
		do {
			pos = str.indexOf(substr, pos + 1);
		} while (n-- > 0 && pos != -1);
		return pos;
	}

	public static String rightPadding(String input, char ch, int L) {

		//
		StringBuilder sb = new StringBuilder(L);
		sb.append(input);

		while (sb.length() < L)
			sb.append(ch);

		return sb.toString();
		//

	}

	public static String userInputProject(String project) {
		Scanner sc = new Scanner(System.in);
		constantString = "Please enter Project";
		printString(constantString);

		project = sc.nextLine();

		project = project.replaceAll(";", ",");
		int count = project.length();
		if (count > 15)
			project = project.substring(0, 14);
		return project;

	}

	public static String userInputDate(String strDate) {

		constantString = "Please enter Due date in the format dd/MM/yyyy";
		printString(constantString);

		printString("");
		Scanner scanner = new Scanner(System.in);
		Date d = null;

		strDate = "";
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
			//
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(d);

			//
		} catch (ParseException e) {

			strDate = "Invalid";

		}
		return strDate;
	}

	public static String userInputStatus(String edit_status) {
		Scanner sc_edit = new Scanner(System.in);
		constantString = "Please enter Status - Pending or Done";
		printString(constantString);

		edit_status = sc_edit.nextLine();

		if (!edit_status.trim().equalsIgnoreCase("Pending"))
			if (!edit_status.trim().equalsIgnoreCase("Done"))
				edit_status = "Pending";

		return edit_status;

	}
	public static String userInputTaskID(String edit_TaskID,String constantString_taskID,List<String> tasks) {
		ToDoList.formatLoadArrayList(tasks);
		constantString = "************Here is the Current To Do List**********";
		ToDoListCF.printString(constantString);
		ToDoListCF.printString("");
		ToDoListCF.printArrayList(tasks);

		Scanner editTask_input = new Scanner(System.in);
		ToDoListCF.printString("");

		ToDoListCF.printString(constantString_taskID);
		edit_TaskID = editTask_input.next();
		return edit_TaskID;
	}

	public static String userInputTaskTitle(String taskTitle) {
		Scanner sc = new Scanner(System.in);

		printString("");

		constantString = "Please enter the task/activity";
		printString(constantString);

		printString("");

		//
		taskTitle = "";
		while (true) {
			taskTitle = sc.nextLine();
			if (taskTitle.equals(""))

				taskTitle = ""; // todo
			else
				taskTitle = taskTitle.replaceAll(";", ",");

			int count = taskTitle.length();
			if (count > 20)
				taskTitle = taskTitle.substring(0, 19);
			return taskTitle;

		}
		//

		// taskTitle = sc.nextLine();

	}

	public static void printArrayList(List<String> print_todoList) {

		Iterator<String> it_PrintToDoList = print_todoList.iterator();

		//
		while (it_PrintToDoList.hasNext()) {
			System.out.println(it_PrintToDoList.next() + " ");
		}

		//

	}

	public static void printString(String constantString) {

		System.out.println(constantString);
		// System.out.println("");
	}

	public static void writeToFile(List<String> tasks) throws FileNotFoundException, IOException {

		File file = new File("src/main/resources/Tasks_LoadFile.txt");

		FileOutputStream fout = new FileOutputStream(file);
		PrintWriter pwrite = new PrintWriter(fout);
		int datList = tasks.size();
		for (String elem : tasks) {
			pwrite.println(elem);
		}
		pwrite.close();
		fout.close();
	}

	public static void clearConsole() {

		printString("\u000C");

		printString("\f");
	}
}
