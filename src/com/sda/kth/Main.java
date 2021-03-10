
package com.sda.kth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void clearScreen(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}

	public static void main(String[] args) {
		String action = "";

		ToDoList.readFile();

		System.out.println(" ********** Welcome to ToDoLy **********");
		System.out.println("");
		ToDoList.checkDone();

		boolean quit = false;
		String mainMenu = "" + "1.  Load/Show Task List \n" + "2. Sort task List (By project)\n"
				+ "3. Sort task List (By Date)\n" + "4. Add New Task\n" + "5. Edit Task\n" + "6. Remove Task\n"
				+ "7. Save and Quit\n";
		while (!quit) {

			Scanner input = new Scanner(System.in);
			System.out.println(mainMenu);
			int choice = input.nextInt();

			switch (choice) {

			case 1:
				ToDoList.displayTaskList();

				break;

			case 2:
				ToDoList.displayTaskListByProject();
				break;
			case 3:
				ToDoList.displayTaskListByDate();
				break;

			case 4:
				ToDoList.createTask();
				break;
			case 5:
				action = "EDIT";
				ToDoList.editTask(action);
				break;
			case 6:
				action = "REMOVE";
				ToDoList.editTask(action);
				break;

			case 7:
				try {
					ToDoList.writeToFile();
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				clearScreen();
				System.exit(0);


				break;
			default:
				System.out.println("Invalid entry try again");

			}
		}

	}

}
