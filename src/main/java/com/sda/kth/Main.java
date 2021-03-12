
package com.sda.kth;

/**
 * This is a main method which triggers the execution of ToDoList App.
 * it is loading tasks from the file by calling readFile().
 * @initSwitch is used to provide the user to choose between different options .
 */
public class Main {
	public static String constantString = "";

	public static void main(String[] args) {

		ToDoList.readFile();
		constantString = " ********** Welcome to ToDoLy **********";
		ToDoListCF.printString(constantString);

		ToDoList.calculateTaskStatus();
		ToDoList.initSwitch();

	}

}
