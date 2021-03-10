package com.sda.kth;

import java.util.List;

public class ToDoListAddTask {

	public static void AddTask(List<String> tasks, List<String> TaskID, List<String> tasks_Project,
			List<String> tasks_Date) {

		System.out.println("Adding elements to the list");

		String status_init = "Pending";

		String taskTitle = "";

		String strDate = "";
		String project = "";

		taskTitle = ToDoListCF.userInputTaskTitle(taskTitle);
		project = ToDoListCF.userInputProject(project);
		strDate = ToDoListCF.userInputDate(strDate);

		String taskID_val = TaskID.get(TaskID.size() - 1).trim();
		int taskIDCounter = Integer.parseInt(taskID_val) + 1;

		//

		tasks.add(String.format("%03d", taskIDCounter) + ";" + taskTitle + ";" + project + ";" + strDate + ";"
				+ status_init);

		tasks_Project.add(project);
		tasks_Date.add(strDate);

		System.out.println("Task added successfully with Status : Pending");
		System.out.println("");

	}

}
