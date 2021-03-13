
package com.sda.kth;

/**
 * This is a main method which triggers the execution of ToDoList App.
 *
 * @author  Rabunnisa Zabiulla
 */
public class Main {
	public static String constantString = "";

	public static void main(String[] args) {
		int doneTasks = 0;
		int pendingTasks = 0;

		ToDoList todo = new ToDoList();
		ToDoListCF listCF = new ToDoListCF();

		todo.readFile();
		constantString = " ********** Welcome to ToDoLy **********";
		listCF.printString(constantString);

		todo.calculateTaskStatus();
		todo.initSwitch();

	}

}
