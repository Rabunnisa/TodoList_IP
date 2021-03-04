# Project Name(Individual Project) - ToDoList App 
Task is to build a todo list application. The application will allow a user to create new tasks, assign them a title and due date, and choose a project for that task to belong to. They will need to use a text based user interface via the command-line (hint: see BlueJ World of Zuul project for some ideas on this). Once they are using the application, the user should be able to also edit, mark as done or remove tasks. They can also quit and save the current task list to file, and then restart the application with the former state restored. 

## Requirements
The solution must achieve the following requirements:

‣ Model a task with a task title, due date, status and project
‣ Display a collection of tasks that can be sorted both by date and project ‣ Support the ability to add, edit, mark as done, and remove tasks
‣ Support a text-based user interface
‣ Load and save task list to file
The solution may also include other creative features at your discretion in case you wish to show some flair

## Module / Technology
Java

## Status
Project is: In-Progress

## Features
**Ready Features :**
* Initial version released
* Basic functionality of the App as mentioned in the requirements

**Pending Features:**
* Enhance functionality of the App
* Format display of ToDoList
* Change layout of the Displaying Task list and also modify to remove one of 2 fields - Status or Done.
* Validate User Inputs especailly for Remove and Edit options. Put some more thoughts on user options here to make is user friendly.
* Remove UnUsed code and Modularize.
* Code formatting
* JavaDoc comments
* Perform Rigorous Unit testing
* Fine tune code to increase performance of the App.
* AOB - Need to evaluate code

## How to run the Application

1:	There are 2 classes in the package - Main & ToDoList.

2:	Run the Main class. ToDoList class contains most of the methods will be used to perform operations.

3:	Once the Main class is executed , the Application loads the current tasks from a file in Project Path.The name of the file is ''Tasks_LoadFile.txt'' .Number of ToDo and Done tasks will be printed in the console.Menu options will also be displayed in the console for User to select.

4:	**Press '1' to Load/Show Task List :** This input displays the ToDo List which is loaded from the ''Tasks_LoadFile.txt''

5:	**Press '2' to Sort task List (By project) :** This option will sort the ToDo List wrt project name and displays in the console

6:	**Press '3' to Sort task List (By Date) :** This option will sort the ToDo List wrt Date and displays in the console

7:	**Press '4' to Add New Task :** This option is to model a new task. When this input is provided ,user will be prompted to enter '' Unique Task Title'' , ''Status'' , ''Due Date in Format dd/MM/yyyy'' , ''Project'', ''Booleand True or False to mark the tasks done and Not-Done respectively''. Once the User provides these inputs the task will be added to the todoList and a message ''Task added successfull'' will be printed in the console.

8:	**Press '5' to Edit New Task :** This Option is used to Edit an existing task in the User's ToDoList. When this option is entered the current list is displayed in the console. A message will also be prompted to ''Enter the Task Title which you would like to EDIT ''. User needs to enter the Task Title which is present in the list to Edit the record. 

	*If the task title matches in the List* , then User will be asked to enter ''enter new task Title'' , ''new Status'', ''new Due date in format dd/MM/yyyy'', ''Boolen True or False''. Once the inputs are provided a message ''Entry Successfully updated'' will be printed. ToDoList will be successfully updated.
	*If the task title doesn't matches in the List*  : A Message ''Re-Enter correct Task Title , Re-Try'' will be displayed and user will be taken to Main Menu

9:	**Press '6' to Edit New Task :** This option is used to delete the Task from the ToDoList. When this input is provided , user will be presented with the current list and will be presented with a message ''Enter the Task Title which you would like to REMOVE''. The user needs to enter the correct task title which needs to be removed.Once the input is provided by the user - 

	*If the task title matches in the List* : Entry will be removed and a message ''Entry Successfully Removed'' will be displayed in the console
	*If the task title doesn't matches in the List*  : A Message ''Re-Enter correct Task Title , Re-Try'' will be displayed and user will be taken to Main Menu

10:	**Press '7' to save the to-do list and exit :** When this option is entered the Program will save the current task list in the same file ''Tasks_LoadFile.txt'' and program will be terminated.
## Contact
Created by Rabunnisa Zabiulla (rabia.zabiulla@gmail.com) - feel free to contact me!