package com.sda.kth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Common Function(CF) class.
 * The purpose of this class is to hold common methods which are used in the application.
 */
public class ToDoListCF {
    static String constantString = "";

    /**
     * The purpose of this method is to get the nth occurring index of a particular character in the string .
     * @param str    String on which operation is required.
     * @param substr is the substring /character whose index needs to be determined .
     * @param n      specifies the occurrence of the character/substring.
     */
    public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = -1;
        do {
            pos = str.indexOf(substr, pos + 1);
        } while (n-- > 0 && pos != -1);
        return pos;
    }

    /**
     * The purpose of this method is to to pad(suffix) a particular character, in front of the input string .
     * The total length of the padded string is also received as a parameter
     *
     * @param input  String on which operation is required.
     * @param ch     is the character which needs to be suffix to the string .
     * @param length The total length of the string after padding .
     */
    public static String rightPadding(String input, char ch, int length) {

        //
        StringBuilder sb = new StringBuilder(length);
        sb.append(input);

        while (sb.length() < length)
            sb.append(ch);

        return sb.toString();
        //

    }

    /**
     * The purpose of this method is to take the input from the user for the project field ,and  return the same .
     * It also replaces all semicolons entered by user with a comma .
     * Also restricts/truncates the length of the project to 15 characters.
     *
     * @param project Name of the project as string.
     */
    public static String userInputProject(String project) {
        Scanner sc = new Scanner(System.in);
        constantString = "Please enter Project";
        printString(constantString);

        project = sc.nextLine();

        project = project.replaceAll(";", ",");
        int count = project.length();
        if (count > 15)
            project = project.substring(0, 14);
        return project;

    }

    /**
     * The purpose of this method is to take the input from the user for the DueDate  field ,and  return the same .
     * It checks whether the entered date by user has valid format 'dd/MM/yyyy'.In case of wrong format
     * exception is raised and strDate is returned as "" .
     *
     * @param strDate is the user entered due date .
     */
    public static String userInputDate(String strDate) {

        constantString = "Please enter Due date in the format dd/MM/yyyy";
        printString(constantString);

        printString("");
        Scanner scanner = new Scanner(System.in);
        Date d = null;

        strDate = "";
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            //
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            strDate = formatter.format(d);

            //
        } catch (ParseException e) {

            strDate = "";

        }
        return strDate;
    }

    /**
     * The purpose of this method is to take the input from the user for the status of the task.
     * If the status entered by user does not match Pending or Done ,then the default
     * status of the task would be Pending
     *
     * @param edit_status is the user entered Status.
     */
    public static String userInputStatus(String edit_status) {
        Scanner sc_edit = new Scanner(System.in);
        constantString = "Please enter Status - Pending or Done";
        printString(constantString);

        edit_status = sc_edit.nextLine();

        if (!edit_status.trim().equalsIgnoreCase("Pending"))
            if (!edit_status.trim().equalsIgnoreCase("Done"))
                edit_status = "Pending";

        return edit_status;

    }

    /**
     * The purpose of this method is to take the input from the user for the unique task id.
     *
     * @param edit_TaskID           is the user entered unique task id (Edit operation).
     * @param constantString_taskID it is a constant string to print on the console .
     * @param tasks                 is the array list which has all the current tasks .
     */
    public static String userInputTaskID(String edit_TaskID, String constantString_taskID, List<String> tasks) {
        ToDoList.formatLoadArrayList(tasks);
        constantString = "************Here is the Current To Do List**********";
        ToDoListCF.printString(constantString);
        ToDoListCF.printString("");
        ToDoListCF.printArrayList(tasks);

        Scanner editTask_input = new Scanner(System.in);
        ToDoListCF.printString("");

        ToDoListCF.printString(constantString_taskID);
        edit_TaskID = editTask_input.next();
        return edit_TaskID;
    }

    /**
     * The purpose of this method is to take the input from the user for the Task title/name.
     * It also replaces all semicolons entered by user with a comma .
     * Also restricts/truncates the length of the project to 20 characters.
     *
     * @param taskTitle is the user entered taskTitle .
     */
    public static String userInputTaskTitle(String taskTitle) {
        Scanner sc = new Scanner(System.in);

        printString("");

        constantString = "Please enter the task/activity";
        printString(constantString);

        printString("");

        //
        taskTitle = "";
        while (true) {
            taskTitle = sc.nextLine();
            if (taskTitle.equals(""))

                taskTitle = ""; // todo
            else
                taskTitle = taskTitle.replaceAll(";", ",");

            int count = taskTitle.length();
            if (count > 20)
                taskTitle = taskTitle.substring(0, 19);
            return taskTitle;

        }


    }

    /**
     * The purpose of this method is to print the provided array list using iterator .
     * @param print_todoList is the ArrayList which needs to be printed .
     */
    public static void printArrayList(List<String> print_todoList) {

        Iterator<String> it_PrintToDoList = print_todoList.iterator();

        while (it_PrintToDoList.hasNext()) {
            System.out.println(it_PrintToDoList.next() + " ");
        }


    }

    /**
     * The purpose of this method is to print the provided String .
     *
     * @param constantString is the string  which needs to be printed .
     */
    public static void printString(String constantString) {

        System.out.println(constantString);

    }


    /**
     * The purpose of this method is to write contents of the array list into a file.
     *
     * @param tasks is the array list which has all the current tasks .
     */
    public static void writeToFile(List<String> tasks) throws FileNotFoundException, IOException {

        File file = new File("src/main/resources/Tasks_LoadFile.txt");

        FileOutputStream fout = new FileOutputStream(file);
        PrintWriter pwrite = new PrintWriter(fout);
        int datList = tasks.size();
        for (String elem : tasks) {
            pwrite.println(elem);
        }
        pwrite.close();
        fout.close();
    }


}
