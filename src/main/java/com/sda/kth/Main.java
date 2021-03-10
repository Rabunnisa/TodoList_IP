
package com.sda.kth;

/**
 * This is a main method which is used to run the code it has 3 methods important methods used to run the program .
 * @readFile this method is used to read the data from file in this case used to read the task list which is already saved.
 * @CheckDone this method is used to check whether the task is done or pending .
 * @initSwitch this is used to allow user to choose between different options and display all the switch statements .
 */
public class Main {

	public static void main(String[] args) {

		ToDoList.readFile();
		System.out.println(" ********** Welcome to ToDoLy **********");
		System.out.println("");

		ToDoList.checkDone();
		ToDoList.initSwitch();

	}

}
