
package com.sda.kth;

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
