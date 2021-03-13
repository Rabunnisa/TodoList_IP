package com.sda.kth;

import java.util.List;
/**
 * The purpose of this class is to add a new task to the existing ToDoList by taking inputs.
 */
public class ToDoListAddTask {

	static String constantString = "";
	/**
	 * This method is used to add the task with specific user inputs and it is always added with initial status pending.
	 * @param tasks it is a main Arraylist which has the current tasks and new values of tasks will be appended to it  .
	 * @param TaskID it is unique id assigned to the task added.
	 * @param tasks_Project the project name provided by the user is also appended to the list.
	 * @param tasks_Date the date provided by the user is also appended to this list .
	 */
	public static void AddTask(List<String> tasks, List<String> TaskID, List<String> tasks_Project,
							   List<String> tasks_Date,String taskTitle,String project,String strDate) {

		constantString = "Adding elements to the list";
		ToDoListCF.printString(constantString);

		String status_init = "Pending";





		if (!strDate.trim().equalsIgnoreCase("Invalid")) {

			String taskID_val = TaskID.get(TaskID.size() - 1).trim();
			int taskIDCounter = Integer.parseInt(taskID_val) + 1;

			//

			tasks.add(String.format("%03d", taskIDCounter) + ";" + taskTitle + ";" + project + ";" + strDate + ";"
					+ status_init);

			tasks_Project.add(project);
			tasks_Date.add(strDate);

			constantString = "Entry Successfully added";
			ToDoListCF.printString(constantString);
			constantString = "";
			ToDoListCF.printString(constantString);

		} else {
			constantString = "In valid date - Task addition cancelled\n";
			ToDoListCF.printString(constantString);

		}
	}

}
