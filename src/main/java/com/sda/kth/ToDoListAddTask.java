package com.sda.kth;

import java.util.List;

public class ToDoListAddTask {

	static String constantString = "";

	public static void AddTask(List<String> tasks, List<String> TaskID, List<String> tasks_Project,
			List<String> tasks_Date) {

		constantString = "Adding elements to the list";
		ToDoListCF.printString(constantString);

		String status_init = "Pending";

		String taskTitle = "";

		String strDate = "";
		String project = "";

		taskTitle = ToDoListCF.userInputTaskTitle(taskTitle);
		project = ToDoListCF.userInputProject(project);
		strDate = ToDoListCF.userInputDate(strDate);

		if (!strDate.trim().equalsIgnoreCase("Invalid")) {

			String taskID_val = TaskID.get(TaskID.size() - 1).trim();
			int taskIDCounter = Integer.parseInt(taskID_val) + 1;

			//

			tasks.add(String.format("%03d", taskIDCounter) + ";" + taskTitle + ";" + project + ";" + strDate + ";"
					+ status_init);

			tasks_Project.add(project);
			tasks_Date.add(strDate);

			constantString = "Adding elements to the list";
			ToDoListCF.printString(constantString);
			constantString = "";
			ToDoListCF.printString(constantString);

		} else {
			constantString = "In valid date - Task addition cancelled\n";
			ToDoListCF.printString(constantString);

		}
	}

}
