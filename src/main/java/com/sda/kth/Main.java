
package com.sda.kth;

/**
 * This is a main Class which triggers the execution of ToDoList App.
 *
 * @author Rabunnisa Zabiulla
 */
public class Main {
	public static String constantString = "";

	public static void main(String[] args) {

		ToDoList todo = new ToDoList();
		ToDoListCF listCF = new ToDoListCF();

		todo.readFile();
		constantString = " ********** Welcome to ToDoLy **********";
		listCF.printString(constantString);

		todo.calculateTaskStatus();
		todo.initSwitch();

	}

}
