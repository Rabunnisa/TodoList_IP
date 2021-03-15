package com.sda.kth;

import java.util.List;
import java.util.Scanner;


/**
 * This class is used to edit ,mark as done and remove a particular tasks from an existing tasks list.
 */
public class ToDoListEditTask {
	static String constantString = "";
	/**
	 * This method is used to validate whether the TaskId provided by the user is valid and also to
	 * capture the index of the TaskId which needs to be edit .
	 * @param tasks this Arraylist contains all the current tasks.
	 * @param edit_TaskID it is unique id from the existing task list which to be edited.
	 * @param edit_taskTitle it is new/edited task title provided by the user.
	 * @param edit_project tit is new/edited task project provided by the user.
	 * @param edit_strDate it is new/edited task date provided by the user.
	 * @param edit_status  it is status of task.
	 */

	public static void editTask(List<String> tasks,String edit_TaskID,String edit_taskTitle,String edit_project,String edit_strDate,String edit_status) {



		ToDoList.formatLoadArrayList(tasks);

		String task_name = edit_TaskID;
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
			edit_taskTitle = ToDoListCF.userInputTaskTitle(edit_taskTitle);
			edit_project = ToDoListCF.userInputProject(edit_project);
			edit_strDate = ToDoListCF.userInputDate(edit_strDate);

			editTaskAtIndex(tasks, editIndex, t_task,edit_taskTitle,edit_project,edit_strDate,edit_status);
		}

		else {
			constantString = "Please Enter correct TaskId , Re-Try";
			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");
	}

	/**
	 * This method is used to edit the tasks with specific index of TaskId provided.
	 * @param tasks this Arraylist contains all the current tasks.
	 * @param editIndex it is a index derived by the provided unique TaskId  .
	 * @param taskId it is a unique TaskId provided by the user to edit .
	 * @param edit_taskTitle it is new/edited task title provided by the user.
	 * @param edit_project it is new/edited task project provided by the user.
	 * @param edit_strDate it is new/edited task date provided by the user.
	 * @param edit_status  it is status of task.
	 */

	public static void editTaskAtIndex(List<String> tasks, int editIndex, String taskId,String edit_taskTitle,
									   String edit_project,String edit_strDate,String edit_status) {

		String editEntry = "";




		if (!edit_strDate.trim().equalsIgnoreCase("")) {
			edit_status = ToDoListCF.userInputStatus(edit_status);
			editEntry = taskId + ";" + edit_taskTitle + ";" + edit_project + ";" + edit_strDate + ";" + edit_status;
			tasks.set(editIndex, editEntry);
			constantString = "Entry Successfully updated";
			ToDoListCF.printString(constantString);
			ToDoListCF.printString("");

		} else {
			constantString = "Invalid date : Entry not updated pls try again \n";
			ToDoListCF.printString(constantString);

		}
		// ToDoList.formatLoadArrayList(tasks);
	}

	/**
	 * This method is used to Remove a specific tasks with an index of TaskId provided.
	 * @param tasks this Arraylist contains all the current tasks.
	 * @param edit_TaskID it is unique id from the existing task list which needs to be removed .
	 */

	public static void RemoveTaskIndex(List<String> tasks,String edit_TaskID) {

		ToDoList.formatLoadArrayList(tasks);

		String task_name = edit_TaskID;


		String taskId = "";
		int t_flag = 0;
		int removeIndex = 0;
		for (int i = 1; i < tasks.size(); i++) {
			taskId = tasks.get(i).toString().substring(0, tasks.get(i).toString().indexOf(";")).trim();
			if (task_name.equalsIgnoreCase(taskId)) {
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
			constantString = "Please Enter correct TaskId , Re-Try";
			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");
	}
	/**
	 * This method is used to Mark specific task as done with specific TaskId provided by the user.
	 * @param tasks this Arraylist contains all the current tasks.
	 * @param edit_TaskID it is unique id from the existing task list which needs to be marked as status done .
	 */
	public static void MarkDone(List<String> tasks,String edit_TaskID)

	{

		String task_name = edit_TaskID;
		//


		String taskId = "";
		String t_arrayVal = "";
		int t_flag = 0;
		int doneIndex = 0;
		int beginIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < tasks.size(); i++) {
			t_arrayVal = tasks.get(i).toString();
			taskId = tasks.get(i).toString().substring(0, tasks.get(i).toString().indexOf(";")).trim();
			if (task_name.equalsIgnoreCase(taskId)) {
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
			constantString = "Please Enter correct TaskId , Re-Try";

			ToDoListCF.printString(constantString);

		}
		ToDoListCF.printString("");

	}

}
