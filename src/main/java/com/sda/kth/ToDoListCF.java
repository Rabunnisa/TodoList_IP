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
		System.out.println("Please enter Project");
		project = sc.nextLine();
		return project;

	}

	public static String userInputDate(String strDate) {

		System.out.println("Please enter Due date");
		System.out.println("Please enter your Due date in the format dd/MM/yyyy");
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
			e.printStackTrace();
		}
		return strDate;
	}

	public static String userInputTaskTitle(String taskTitle) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");

		System.out.println("Please enter the task/activity");

		taskTitle = sc.nextLine();

		return taskTitle;

	}

	public static void printArrayList(List<String> print_todoList) {

		Iterator<String> it_PrintToDoList = print_todoList.iterator();

		//
		while (it_PrintToDoList.hasNext()) {
			System.out.println(it_PrintToDoList.next() + " ");
		}

		//

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

	public static void ClearConsole() {

		System.out.print("\u000C");

		System.out.print("\f");
	}
}
