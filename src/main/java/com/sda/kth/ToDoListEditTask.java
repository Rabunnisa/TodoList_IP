package com.sda.kth;

import java.util.List;
import java.util.Scanner;

public class ToDoListEditTask {

	public static void editTask(List<String> tasks) {

		System.out.println(" **********Here is the Current To Do List**********");
		System.out.println("");
		ToDoListCF.printArrayList(tasks);

		Scanner editTask_input = new Scanner(System.in);
		System.out.println("");

		System.out.println("Enter the Unique task ID from the above list which you would like to EDIT  ");

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

		else
			System.out.println("Re-Enter correct Task Title , Re-Try");
		System.out.println("");
	}

	public static void editTaskatIndex(List<String> tasks, int editIndex, String t_task) {

		String editEntry = "";
		String edit_taskTitle = "";
		String edit_project = "";
		String edit_strDate = "";

		edit_taskTitle = ToDoListCF.userInputTaskTitle(edit_taskTitle);
		edit_project = ToDoListCF.userInputProject(edit_project);
		edit_strDate = ToDoListCF.userInputDate(edit_strDate);

		Scanner sc_edit = new Scanner(System.in);
		System.out.println("Please enter new Status - Pending or Done");
		String edit_status = sc_edit.nextLine();

		editEntry = t_task + ";" + edit_taskTitle + ";" + edit_project + ";" + edit_strDate + ";" + edit_status + ";";
		tasks.set(editIndex, editEntry);
		System.out.println("Entry Successfully updated");
		System.out.println("");

	}

	public static void RemoveTaskIndex(List<String> tasks) {

		System.out.println(" **********Here is the Current To Do List**********");
		System.out.println("");
		ToDoListCF.printArrayList(tasks);
		System.out.println("");
		System.out.println("Enter the Unique task ID from the above list which you would like to REMOVE ");

		Scanner removeTask_input = new Scanner(System.in);
		System.out.println("");

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
			System.out.println("**********Entry Successfully Removed************");
		}

		else
			System.out.println("In correct Task ID , Re-Try");
		System.out.println("");
	}

	public static void MarkDone(List<String> tasks)

	{
		System.out.println(" **********Here is the Current To Do List**********");
		System.out.println("");
		ToDoListCF.printArrayList(tasks);
		System.out.println("");
		System.out.println("Enter the Unique task ID which needs to be marked DONE ");

		Scanner removeTask_input = new Scanner(System.in);
		System.out.println("");

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

			System.out.println("**********Successful ! Marked Done************");
		}

		else
			System.out.println("In correct Task ID , Re-Try");
		System.out.println("");

	}

}
