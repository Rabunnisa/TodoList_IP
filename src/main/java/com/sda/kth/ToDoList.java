package com.sda.kth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Here is a todolist App implementation using Add ,Edit and Update the given task
 */
public class ToDoList {

	public static List<String> tasks = new ArrayList<>();
	public static List<String> tasks_Date = new ArrayList<>();
	public static List<String> tasks_Status = new ArrayList<>();
	public static List<String> tasks_Title = new ArrayList<>();
	public static List<String> tasks_Project = new ArrayList<>();
	public static List<String> sortByProject = new ArrayList<>();
	public static List<String> sortBydate = new ArrayList<>();
	public static List<String> TaskID = new ArrayList<>();
	public static List<Date> dateList = new ArrayList<Date>();

	//

	public static void readFile() {

		tasks.clear();

		try {

			Scanner s = new Scanner(new File("src/main/resources/Tasks_LoadFile.txt"));
			while (s.hasNextLine()) {
				tasks.add(s.nextLine());

			}

			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToDoList.loadInstance(tasks);

	}

	public static void initSwitch() {

		String mainMenu = "" + "1. Load/Show Task List (by Date or Project) \n" + "2. Add New Task\n"
				+ "3. Edit Task (Update,Mark as Done , remove)\n" + "4. Save and Quit\n";
		//

		Scanner input = new Scanner(System.in);
		System.out.println(" Pick an option\n");
		System.out.println(mainMenu);

		while (true) {

			int choice = 0;

			try {
				choice = input.nextInt();
			} catch (InputMismatchException nfe) {
				System.out.println("Error in input : You have entered a non Integer field value");
			}

			switch (choice) {

			case 1:

				ToDoListDisplayTaskList.displayTaskList(tasks);

				System.out.println("Select the below sub options");
				String subMenuDisplay = "" + "11.  Display list by Project \n" + "12. Display list by Date\n";
				Scanner subinput = new Scanner(System.in);
				System.out.println(subMenuDisplay);
				int subChoiceDisplay = 0;
				try {
					subChoiceDisplay = subinput.nextInt();
				} catch (InputMismatchException nfe) {
					System.out.println("Invalid Option - May be you have entered a non Integer value");
				}

				switch (subChoiceDisplay) {
				case 11:
					ToDoListDisplayTaskList.displayTaskListByProject(tasks, sortByProject, tasks_Project);
					System.out.println(mainMenu);
					break;
				case 12:
					ToDoListDisplayTaskList.displayTaskListByDate(tasks, tasks_Date, sortBydate, dateList);
					System.out.println(mainMenu);
					break;
				default:
					System.out.println("Wrong Input !");
					System.out.println("Please Try again now  ");
					System.out.println(mainMenu);
				}

				// Nested Switch

				break;

			case 2:

				ToDoListAddTask.AddTask(tasks, TaskID, tasks_Project, tasks_Date);
				System.out.println(mainMenu);
				break;
			case 3:

				// Nested Switch

				System.out.println(" Select the below sub options");
				String subMenuEdit = "" + "31. Edit/Modify a Task entry \n" + "32. Remove\n" + "33. Mark as Done\n";
				Scanner subinputEdit = new Scanner(System.in);
				System.out.println(subMenuEdit);
				int subChoiceEdit = 0;
				//
				try {
					subChoiceEdit = subinputEdit.nextInt();
				} catch (InputMismatchException nfe) {
					System.out.println("Invalid Option - May be you have entered a non Integer value");
				}
				//

				switch (subChoiceEdit) {
				case 31:

					ToDoListEditTask.editTask(tasks);
					System.out.println(mainMenu);
					break;
				case 32:

					ToDoListEditTask.RemoveTaskIndex(tasks);
					System.out.println(mainMenu);
					break;

				case 33:

					ToDoListEditTask.MarkDone(tasks);
					System.out.println(mainMenu);
					break;
				default:
					System.out.println("Wrong Input !");

					System.out.println("Please Try again now  ");
					System.out.println(mainMenu);

				}

				// Nested Switch
				break;

			case 4:
				try {
					ToDoListCF.writeToFile(tasks);
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				System.exit(0);
				break;

			default:
				System.out.println("Invalid entry try again");
				System.out.println(mainMenu);

			}
		}
	}

	//

	public static void loadInstance(List<String> tasks) {

		tasks_Project.clear();
		tasks_Date.clear();
		tasks_Title.clear();
		TaskID.clear();
		tasks_Status.clear();

		String t_ToDoListVal = "";
		for (int i = 0; i < tasks.size(); i++) {
			int firstIndexProject = 0;
			int beginIndexProject = 0;
			int endIndexProject = 0;
			int beginIndexDate = 0;
			int endIndexDate = 0;
			int beginIndexTaskId = 0;
			int endIndexTaskId = 0;
			String t_TaskID = "";
			String t_TaskTitle = "";
			String t_Project = "";
			String t_Date = "";
			String t_Status = "";

			t_ToDoListVal = tasks.get(i).toString();

			firstIndexProject = t_ToDoListVal.indexOf(";");

			beginIndexProject = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 1);
			endIndexProject = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 2);

			beginIndexDate = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 2);
			endIndexDate = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 3);

			endIndexTaskId = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 0);

			int beginIndexStatus = 0;
			int endIndexStatus = 0;

			beginIndexStatus = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 3);
			endIndexStatus = t_ToDoListVal.length();

			int beginIndexTaskTitle = 0;
			int endIndexTaskTitle = 0;

			beginIndexTaskTitle = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 0);
			endIndexTaskTitle = ToDoListCF.ordinalIndexOf(t_ToDoListVal, ";", 1);

			String temp = ToDoListCF.rightPadding("001", ' ', 5);

			t_TaskID = t_ToDoListVal.substring(0, endIndexTaskId + 1).trim();
			t_TaskTitle = t_ToDoListVal.substring(beginIndexTaskTitle + 1, endIndexTaskTitle + 1).trim();

			t_Project = t_ToDoListVal.substring(beginIndexProject + 1, endIndexProject + 1).trim();
			t_Date = t_ToDoListVal.substring(beginIndexDate + 1, endIndexDate + 1).trim();
			t_Status = t_ToDoListVal.substring(beginIndexStatus + 1, endIndexStatus).trim();

			String t_TaskID_temp = "";

			t_TaskID = ToDoListCF.rightPadding(t_TaskID, ' ', 10);

			t_TaskTitle = ToDoListCF.rightPadding(t_TaskTitle, ' ', 20);
			t_Project = ToDoListCF.rightPadding(t_Project, ' ', 15);
			t_Date = ToDoListCF.rightPadding(t_Date, ' ', 15);
			t_Status = ToDoListCF.rightPadding(t_Status, ' ', 10);
			String format_ToDoListVal = "";

			format_ToDoListVal = t_TaskID + t_TaskTitle + t_Project + t_Date + t_Status;

			TaskID.add(ToDoListCF.rightPadding(t_ToDoListVal.substring(0, endIndexTaskId), ' ', 8));
			tasks_Title.add(t_ToDoListVal.substring(beginIndexTaskTitle + 1, endIndexTaskTitle).trim());
			tasks_Project.add(t_ToDoListVal.substring(beginIndexProject + 1, endIndexProject).trim());
			tasks_Date.add(t_ToDoListVal.substring(beginIndexDate + 1, endIndexDate).trim());
			tasks_Status.add(t_ToDoListVal.substring(beginIndexStatus + 1, endIndexStatus).trim());

			tasks.set(i, format_ToDoListVal);
		}

	}
	// End of Load

	public static void checkDone() {
		int doneTasks = 0;
		int pendingTasks = 0;
		int beginIndexStatus = 0;
		int endIndexStatus = 0;
		for (int i = 1; i < tasks.size(); i++) {

			String checkStatus = "";
			String taskVal = tasks.get(i);
			beginIndexStatus = ToDoListCF.ordinalIndexOf(taskVal, ";", 3);
			endIndexStatus = taskVal.length();

			checkStatus = taskVal.substring(beginIndexStatus + 1, endIndexStatus);

			if (checkStatus.trim().equalsIgnoreCase("Pending"))
				pendingTasks++;
			else
				doneTasks++;

		}

		System.out.println("You have " + pendingTasks + " tasks todo and " + doneTasks + " tasks are done\n");
	}

}
