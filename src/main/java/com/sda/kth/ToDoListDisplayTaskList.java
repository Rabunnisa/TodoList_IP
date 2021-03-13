package com.sda.kth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
/**
 * This class is used to Display the tasks provided by the user in the ascending order of Unique TaskId,
		*/
public class ToDoListDisplayTaskList {
	static String constantString = "";

	/**
	 * This method is used to validate whether the TaskId provided by the user is valid and also to
	 * capture the index of the TaskId which needs to be edit .
	 * @param tasks this Arraylist contains all the tasks which are provided by the user
	 */
	public static void displayTaskList(List<String> tasks) {
		ToDoList todo = new ToDoList();
		constantString = " **********To Do List is (Sorted by Unique Task ID) **********";
		ToDoListCF.printString(constantString);
		constantString = "";

		ToDoListCF.printString(constantString);

		tasks = tasks.stream().distinct().collect(Collectors.toList());

		todo.formatLoadArrayList(tasks);
		ToDoListCF.printArrayList(tasks);

		ToDoListCF.printString(constantString);
	}

	public static void displayTaskListByProject(List<String> tasks, List<String> sortByProject,
			List<String> tasks_Project) {
		ToDoList.formatLoadArrayList(tasks);
		sortByProject.clear();

		sortByProject.addAll(tasks);

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

		constantString = " **********To Do List Sorted by Project Name **********";
		ToDoListCF.printString(constantString);
		ToDoListCF.printArrayList(sortByProject);

		constantString = "";
		ToDoListCF.printString(constantString);

		constantString = "Pick an option\n";
		ToDoListCF.printString(constantString);

	}

	public static void displayTaskListByDate(List<String> tasks, List<String> tasks_Date, List<String> sortBydate,
			List<Date> dateList) {
		ToDoList.formatLoadArrayList(tasks);
		sortBydate.clear();
		dateList.clear();
		sortBydate.addAll(tasks);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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

		Date temp = null;
		String tempTwo = null;
		while (swapped) {

			swapped = false;

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
		constantString = " **********To Do List Sorted by Date  **********";
		ToDoListCF.printString(constantString);

		ToDoListCF.printString("");
		constantString = "TaskID;   Task;             Project;       DueDate;       Status   ";
		ToDoListCF.printString(constantString);

		ToDoListCF.printArrayList(sortBydate);
		ToDoListCF.printString("");
		constantString = "Pick an option\n";
		ToDoListCF.printString(constantString);
	}

}
