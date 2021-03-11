package com.sda.kth;

import java.util.List;
import java.util.Scanner;

public class ToDoListEditTask {
	static String constantString = "";

	public static void editTask(List<String> tasks) {

		constantString = "************Here is the Current To Do List**********";
		ToDoListCF.printString(constantString);
		ToDoListCF.printString("");

		ToDoList.formatLoadArrayList(tasks);
		ToDoListCF.printArrayList(tasks);

		Scanner editTask_input = new Scanner(System.in);
		ToDoListCF.printString("");
		constantString = "Enter the Unique task ID from the above list which you would like to EDIT  ";
		ToDoListCF.printString(constantString);

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

			editTaskatIndex(tasks, editIndex, t_task);
		}

		else {
			constantString = "Re-Enter correct Task Title , Re-Try";
			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");
	}

	public static void editTaskatIndex(List<String> tasks, int editIndex, String t_task) {

		String editEntry = "";
		String edit_taskTitle = "";
		String edit_project = "";
		String edit_strDate = "";
		String edit_status = "";

		edit_taskTitle = ToDoListCF.userInputTaskTitle(edit_taskTitle);
		edit_project = ToDoListCF.userInputProject(edit_project);
		edit_strDate = ToDoListCF.userInputDate(edit_strDate);

		if (!edit_strDate.trim().equalsIgnoreCase("Invalid")) {
			edit_status = ToDoListCF.userInputStatus(edit_status);
			editEntry = t_task + ";" + edit_taskTitle + ";" + edit_project + ";" + edit_strDate + ";" + edit_status;
			tasks.set(editIndex, editEntry);
			constantString = "Entry Successfully updated";
			ToDoListCF.printString(constantString);
			ToDoListCF.printString("");

		} else {
			constantString = "Invalid date : Entry not updated pls try again \n";
			ToDoListCF.printString(constantString);

		}
	}

	public static void RemoveTaskIndex(List<String> tasks) {
		constantString = " **********Here is the Current To Do List**********";
		ToDoListCF.printString(constantString);
		ToDoListCF.printString("");

		ToDoList.formatLoadArrayList(tasks);
		ToDoListCF.printArrayList(tasks);
		ToDoListCF.printString("");
		constantString = "Enter the Unique task ID from the above list which you would like to REMOVE ";
		ToDoListCF.printString(constantString);

		Scanner removeTask_input = new Scanner(System.in);
		ToDoListCF.printString("");

		String task_name = removeTask_input.next();

		String t_task = "";
		int t_flag = 0;
		int removeIndex = 0;
		for (int i = 1; i < tasks.size(); i++) {
			t_task = tasks.get(i).toString().substring(0, tasks.get(i).toString().indexOf(";")).trim();
			if (task_name.equalsIgnoreCase(t_task)) {
				removeIndex = i;
				t_flag = 1;
				break;
			}

		}

		if (t_flag == 1) {

			tasks.remove(removeIndex);
			constantString = "**********Entry Successfully Removed************";
			ToDoListCF.printString(constantString);

		}

		else {
			constantString = "In correct Task ID , Re-Try";
			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");
	}

	public static void MarkDone(List<String> tasks)

	{

		constantString = " **********Here is the Current To Do List**********";
		ToDoListCF.printString(constantString);
		ToDoListCF.printString("");

		ToDoList.formatLoadArrayList(tasks);
		ToDoListCF.printArrayList(tasks);
		ToDoListCF.printString("");
		constantString = "Enter the Unique task ID which needs to be marked DONE ";

		ToDoListCF.printString(constantString);

		Scanner removeTask_input = new Scanner(System.in);
		ToDoListCF.printString("");

		String task_name = removeTask_input.next();

		String t_task = "";
		String t_arrayVal = "";
		int t_flag = 0;
		int doneIndex = 0;
		int beginIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < tasks.size(); i++) {
			t_arrayVal = tasks.get(i).toString();
			t_task = tasks.get(i).toString().substring(0, tasks.get(i).toString().indexOf(";")).trim();
			if (task_name.equalsIgnoreCase(t_task)) {
				endIndex = ToDoListCF.ordinalIndexOf(t_arrayVal, ";", 3);
				t_arrayVal = t_arrayVal.substring(beginIndex, endIndex);
				t_arrayVal = t_arrayVal + ";" + "Done";
				tasks.set(i, t_arrayVal);
				doneIndex = i;
				t_flag = 1;
				break;
			}

		}

		if (t_flag == 1) {

			constantString = "**********Successful ! Marked Done************";

			ToDoListCF.printString(constantString);

		}

		else {
			constantString = "In correct Task ID , Re-Try";

			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");

	}

}
