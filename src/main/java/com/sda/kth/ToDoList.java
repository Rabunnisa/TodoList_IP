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
 * The purpose of this class is to provide 4 methods which are used to read a file,Provide user options using initSwitch,
 * calculate task status,load and format the Arraylist.
 */
public class ToDoList {

	public static List<String> tasks = new ArrayList<>();
	public static List<String> tasks_Date = new ArrayList<>();
	public static List<String> tasks_Project = new ArrayList<>();
	public static List<String> sortByProject = new ArrayList<>();
	public static List<String> sortBydate = new ArrayList<>();
	public static List<String> TaskID = new ArrayList<>();
	public static List<Date> dateList = new ArrayList<Date>();
	static String constantString = "";

	//
	/**
	 * This method is used to load the tasks from the input file in which the tasks are semicolon separated .
	 */
	public void readFile() {

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
		ToDoList.formatLoadArrayList(tasks);

	}
	/**
	 * This method is used to provide user options to select operations on the TodoList .
	 * for every selected option specific class-method is called
	 */
	public static void initSwitch() {

		String mainMenu = "" + "1. Load/Show Task List (by Date or Project) \n" + "2. Add New Task\n"
				+ "3. Edit Task (Update,Mark as Done , remove)\n" + "4. Save and Quit\n";
		//

		Scanner input = new Scanner(System.in);

		constantString = " Pick an option\n";
		ToDoListCF.printString(constantString);
		ToDoListCF.printString(mainMenu);
		int choice = 0;

		while (true) {


			try {
				choice = input.nextInt();
			} catch (InputMismatchException nfe) {

				constantString = "Input exception !  "
						+ "Error in input : You have entered a non Integer field value , Program Terminated- re run the program !!";
				ToDoListCF.printString(constantString);

				break;
				// choice = 0;
			}

			switch (choice)

			{

			case 1:

				ToDoListDisplayTaskList.displayTaskList(tasks);

				System.out.println("Select the below sub options");
				String subMenuDisplay = "" + "01.  Display list by Project \n" + "02. Display list by Date\n"
						+ "Press any other key to return to main menu";
				Scanner subinput = new Scanner(System.in);

				ToDoListCF.printString(subMenuDisplay);
				int subChoiceDisplay = 0;
				try {
					subChoiceDisplay = subinput.nextInt();
				} catch (InputMismatchException nfe) {
					constantString = "Invalid Option - May be you have entered a non Integer value";

					ToDoListCF.printString(constantString);

				}

				switch (subChoiceDisplay) {
				case 01:
					ToDoListDisplayTaskList.displayTaskListByProject(tasks, sortByProject, tasks_Project);

					ToDoListCF.printString(mainMenu);

					break;
				case 02:
					ToDoListDisplayTaskList.displayTaskListByDate(tasks, tasks_Date, sortBydate, dateList);
					ToDoListCF.printString(mainMenu);
					break;
				default:
					constantString = "Wrong Input ! , Please try again\n";

					ToDoListCF.printString(constantString);

					ToDoListCF.printString(mainMenu);
				}

				// Nested Switch

				break;

			case 2:
				String taskTitle = "";
				String project = "";
				String strDate = "";
				 taskTitle = ToDoListCF.userInputTaskTitle(taskTitle);
				 project = ToDoListCF.userInputProject(project);
				 strDate = ToDoListCF.userInputDate(strDate);
				ToDoListAddTask.AddTask(tasks, TaskID, tasks_Project, tasks_Date,taskTitle,project,strDate);
				constantString = "Select the below  options";
				ToDoListCF.printString(constantString);
				ToDoListCF.printString(mainMenu);
				break;
			case 3:

				// Nested Switch
				constantString = " Select the below sub options\n";
				ToDoListCF.printString(constantString);

				String subMenuEdit = "" + "01. Edit/Modify a Task entry \n" + "02. Remove\n" + "03. Mark as Done\n";
				Scanner subinputEdit = new Scanner(System.in);
				ToDoListCF.printString(subMenuEdit);
				int subChoiceEdit = 0;
				//
				try {
					subChoiceEdit = subinputEdit.nextInt();
				} catch (InputMismatchException nfe) {
					constantString = "Invalid Option - May be you have entered a non Integer value";

					ToDoListCF.printString(constantString);

				}
				//

				switch (subChoiceEdit) {
				case 01:

					ToDoListEditTask.editTask(tasks);
					ToDoListCF.printString(mainMenu);

					break;
				case 02:

					ToDoListEditTask.RemoveTaskIndex(tasks);
					ToDoListCF.printString(mainMenu);
					break;

				case 03:

					ToDoListEditTask.MarkDone(tasks);
					ToDoListCF.printString(mainMenu);
					break;
				default:
					constantString = "Wrong Input ! , Please try again\n";

					ToDoListCF.printString(constantString);
					ToDoListCF.printString(mainMenu);

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
				constantString = "Invalid entry try again";
				ToDoListCF.printString(constantString);
				ToDoListCF.printString(mainMenu);

			}
		}
	}


	/**
	 * This method is used to format and load the  Todolist it also loads the other Arraylists tasks_Project, tasks_Date
	 * TaskID which will be used to perform operations like sorting by Date and Project
	 * @return
	 */
	public static byte formatLoadArrayList(List<String> tasks) {

		tasks_Project.clear();
		tasks_Date.clear();
		TaskID.clear();


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

			tasks_Project.add(t_ToDoListVal.substring(beginIndexProject + 1, endIndexProject).trim());
			tasks_Date.add(t_ToDoListVal.substring(beginIndexDate + 1, endIndexDate).trim());
			//tasks_Status.add(t_ToDoListVal.substring(beginIndexStatus + 1, endIndexStatus).trim());

			tasks.set(i, format_ToDoListVal);
		}

		return 0;
	}
	/**
	 * This method is  called at the beginning of the execution ,to  calculate/display the number of tasks
	 * which are pending and Done
	 */

	public void calculateTaskStatus() {
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
		constantString = "You have " + pendingTasks + " tasks todo and " + doneTasks + " tasks are done\n";

		ToDoListCF.printString(constantString);
	}

}
