package com.sda.kth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Todo list is implemented to perform  various tasks
 */
public class ToDoList {

	public static List<String> tasks = new ArrayList<>();
	public static List<String> tasks_Date = new ArrayList<>();
	public static List<String> tasks_Project = new ArrayList<>();
	public static List<String> sortByProject = new ArrayList<>();
	public static List<String> sortBydate = new ArrayList<>();
	public static List<Date> dateList = new ArrayList<Date>();

	public static void readFile() {

		tasks.clear();

		try {

			Scanner s = new Scanner(new File("Tasks_LoadFile.txt"));
			while (s.hasNextLine()) {
				tasks.add(s.nextLine());

			}

			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadInstance();

	}

	public static void loadInstance() {
		tasks = tasks.stream().distinct().collect(Collectors.toList());
		int firstIndexProject = 0;
		int beginIndexProject = 0;
		int endIndexProject = 0;
		tasks_Project.clear();
		tasks_Date.clear();

		int beginIndexDate = 0;
		int endIndexDate = 0;

		String t_project = "";
		for (int i = 0; i < tasks.size(); i++) {
			t_project = tasks.get(i).toString();
			firstIndexProject = t_project.indexOf(";");
			beginIndexProject = ordinalIndexOf(t_project, ";", 2);
			endIndexProject = ordinalIndexOf(t_project, ";", 3);

			beginIndexDate = ordinalIndexOf(t_project, ";", 1);
			endIndexDate = ordinalIndexOf(t_project, ";", 2);

			tasks_Project.add(t_project.substring(beginIndexProject + 1, endIndexProject).trim());

			tasks_Date.add(t_project.substring(beginIndexDate + 1, endIndexDate).trim());

		}

	}
	// End of Load

	public static int ordinalIndexOf(String str, String substr, int n) {
		int pos = -1;
		do {
			pos = str.indexOf(substr, pos + 1);
		} while (n-- > 0 && pos != -1);
		return pos;
	}

	// Display Tasks which are done and Not done
	public static void checkDone() {
		int doneTasks = 0;
		int pendingTasks = 0;
		for (int i = 1; i < tasks.size(); i++) {
			// get first object to compare to
			String taskVal = tasks.get(i);
			if (taskVal.contains("false"))
				pendingTasks++;
			else
				doneTasks++;

		}

		System.out.println("You have " + pendingTasks + " tasks todo and " + doneTasks + " tasks are done\n");
	}

	public static void writeToFile() throws FileNotFoundException, IOException {

		File file = new File("Tasks_LoadFile.txt");

		FileOutputStream fout = new FileOutputStream(file);
		PrintWriter pwrite = new PrintWriter(fout);
		int datList = tasks.size();
		for (String elem : tasks) {
			pwrite.println(elem);
		}
		pwrite.close();
		fout.close();
	}

	public static void createTask() {

		System.out.println("Adding elements to the list");

		Scanner sc = new Scanner(System.in);
		System.out.println("");

		System.out.println("Please enter task Title");
		String taskTitle = sc.nextLine();

		System.out.println("Please enter Status");
		String status = sc.nextLine();

		System.out.println("Please enter Due date");
		System.out.println("Please enter your Due date in the format dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		Date d = null;

		String strDate = "";
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
			//
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			strDate = formatter.format(d);

			//
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Please enter Project");
		String project = sc.nextLine();

		System.out.println("Enter boolean input TRUE for the task to mark complete and FALSE to mark task pending");
		boolean isDone = sc.nextLine() != null;

		tasks.add(taskTitle + ";" + status + ";" + strDate + ";" + project + ";" + isDone);
		tasks_Project.add(project);
		tasks_Date.add(strDate);

		System.out.println("Task added successfully.");
		System.out.println("project Task added successfully." + tasks_Project);

	}

	// Sort by Project Method
	public static void displayTaskListByProject() {
		loadInstance();
		sortByProject.clear();

		sortByProject.addAll(tasks);
		// System.out.println("val is" + tasks_Project);
		// Start
		boolean swapped = true;
		String t_tasksProject;
		String t_tasks;
		while (swapped) {
			swapped = false;

			int size = tasks_Project.size();
			for (int i = 1; i < size - 1; i++) {

				if (tasks_Project.get(i).compareTo(tasks_Project.get(i + 1)) > 0) {
					t_tasksProject = tasks_Project.get(i);
					t_tasks = sortByProject.get(i);

					tasks_Project.set(i, tasks_Project.get(i + 1));
					tasks_Project.set(i + 1, t_tasksProject);

					sortByProject.set(i, sortByProject.get(i + 1));
					sortByProject.set(i + 1, t_tasks);

					swapped = true;
				}
			}
		}

		System.out.println(" **********To Do List Sorted by Project list **********");
		System.out.println();

		Iterator<String> it_sortProject = sortByProject.iterator();
		while (it_sortProject.hasNext()) {
			System.out.println(it_sortProject.next() + " ");
		}
		System.out.println("");
	}

	public static void displayTaskList() {

		System.out.println(" **********To Do List is **********");
		System.out.println("");

		tasks = tasks.stream().distinct().collect(Collectors.toList());

		Iterator<String> iter = tasks.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next() + " ");
		}
		loadInstance();
		System.out.println("");
	}

	public static void ClearConsole() {

		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void editTask(String action) {

		System.out.println(" **********Here is the Current To Do List**********");
		System.out.println("");
		Iterator<String> it_task = tasks.iterator();
		while (it_task.hasNext()) {
			System.out.println(it_task.next() + " ");
		}

		Scanner editTask_input = new Scanner(System.in);
		System.out.println("");
		if (action.equalsIgnoreCase("REMOVE")) {
			System.out.println("Enter the Task Title which you would like to REMOVE ");
		} else {
			System.out.println("Enter the Task Title which you would like to EDIT ");
		}
		String task_name = editTask_input.next();

		String t_task = "";
		int t_flag = 0;
		int editIndex = 0;
		for (int i = 1; i < tasks.size(); i++) {
			t_task = tasks.get(i).toString().substring(0, tasks.get(i).toString().indexOf(";")).trim();
			if (task_name.equalsIgnoreCase(t_task)) {
				editIndex = i;
				t_flag = 1;
				break;
			}

		}

		if (t_flag == 1) {
			System.out.println("Found");
			editTaskIndex(editIndex, action);
		}

		else
			System.out.println("Re-Enter correct Task Title , Re-Try");
		System.out.println("");
	}

	public static void editTaskIndex(int editIndex, String action) {
		if (action.equalsIgnoreCase("REMOVE")) {
			tasks.remove(editIndex);

			System.out.println("**********Entry Successfully Removed************");
			System.out.println();
		} else {
			String editEntry = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("");

			System.out.println("Please enter new task Title");
			String edit_taskTitle = sc.nextLine();

			System.out.println("Please enter new Status");
			String edit_status = sc.nextLine();

			System.out.println("Please enter new Due date");
			System.out.println("Please enter your new Due date in the format dd/MM/yyyy");
			Scanner scanner = new Scanner(System.in);
			Date edit_Date = null;
			String edit_strDate = "";
			try {
				edit_Date = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				edit_strDate = formatter.format(edit_Date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			System.out.println("Please enter new Project");
			String edit_project = sc.nextLine();

			System.out.println("Enter boolean input TRUE for the task to mark complete and FALSE to mark task pending");
			boolean eidt_isDone = sc.nextLine() != null;

			editEntry = edit_taskTitle + ";" + edit_status + ";" + edit_strDate + ";" + edit_project + ";"
					+ eidt_isDone;
			tasks.set(editIndex, editEntry);
			System.out.println("Entry Successfully updated");
			System.out.println("");

		}
	}

	public static void displayTaskListByDate() {
		sortBydate.clear();
		dateList.clear();
		sortBydate.addAll(tasks);

		System.out.println(" **********Entering  Sorted by Date list **********");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(" **********Entering12  Sorted by Date list **********");

		tasks_Date.remove(0);

		for (int j = 0; j < tasks_Date.size(); j++) {
			try {

				dateList.add(simpleDateFormat.parse(tasks_Date.get(j)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		boolean swapped = true;
		String t_firstrecord = null;
		t_firstrecord = sortBydate.get(0);
		sortBydate.remove(0);
		System.out.println("ArrayList size is " + sortBydate.size());
		Date temp = null;
		String tempTwo = null;
		while (swapped) {
			System.out.println("Inside While");
			swapped = false;
			// x++;
			int handsize = dateList.size();

			for (int i = 0; i < handsize - 1; i++) {

				if (dateList.get(i).compareTo(dateList.get(i + 1)) > 0) {
					temp = dateList.get(i);
					tempTwo = sortBydate.get(i);

					dateList.set(i, dateList.get(i + 1));
					dateList.set(i + 1, temp);

					sortBydate.set(i, sortBydate.get(i + 1));
					sortBydate.set(i + 1, tempTwo);

					swapped = true;
				}
			}
		}

		System.out.println(" **********To Do List Sorted by Date list **********");

		System.out.println();

		Iterator<String> it_sortDate = sortBydate.iterator();
		System.out.println("TaskTitle; Status; DueDate (DD/MM/YYYY); Project; Done");
		while (it_sortDate.hasNext()) {
			System.out.println(it_sortDate.next() + " ");
		}
		System.out.println("");
	}

}
