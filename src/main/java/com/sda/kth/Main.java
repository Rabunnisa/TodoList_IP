
package com.sda.kth;

public class Main {

	public static void main(String[] args) {

		ToDoList.readFile();
		System.out.println(" ********** Welcome to ToDoLy **********");
		System.out.println("");

		ToDoList.checkDone();
		ToDoList.initSwitch();

	}

}
