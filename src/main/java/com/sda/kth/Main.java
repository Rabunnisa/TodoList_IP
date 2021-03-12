
package com.sda.kth;

/**
 * This is a main method which triggers the execution of ToDoList App.
 * @readFile() it is called to load tasks from the file .
 * @initSwitch is called to provide the user to choose between different options and sub options of the App.
 * @printString is called with a constant
 *
 *
 * @author  Rabunnisa Zabiulla
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
