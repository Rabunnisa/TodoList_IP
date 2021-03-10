package com.sda.kth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoListDisplayTaskList {

	public static void displayTaskList(List<String> tasks) {

		System.out.println(" **********To Do List is (Sorted by Unique Task ID) **********");
		System.out.println("");

		tasks = tasks.stream().distinct().collect(Collectors.toList());

		ToDoList.loadInstance(tasks);
		ToDoListCF.printArrayList(tasks);

		System.out.println("");
	}

	public static void displayTaskListByProject(List<String> tasks, List<String> sortByProject,
			List<String> tasks_Project) {
		ToDoList.loadInstance(tasks);
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

		System.out.println(" **********To Do List Sorted by Project list **********");
		System.out.println();
		ToDoListCF.printArrayList(sortByProject);

		System.out.println("");
		System.out.println(" Pick an option\n");

	}

	public static void displayTaskListByDate(List<String> tasks, List<String> tasks_Date, List<String> sortBydate,
			List<Date> dateList) {
		ToDoList.loadInstance(tasks);
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

		System.out.println(" **********To Do List Sorted by Date list **********");

		System.out.println();

		System.out.println("TaskID;   Task;             Project;       DueDate;       Status   ");

		ToDoListCF.printArrayList(sortBydate);

		System.out.println("");
		System.out.println(" Pick an option\n");

	}

}
