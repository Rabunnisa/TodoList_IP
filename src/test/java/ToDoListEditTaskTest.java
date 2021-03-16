import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListCF;
import com.sda.kth.ToDoListDisplayTaskList;
import com.sda.kth.ToDoListEditTask;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The purpose of this class is to test various functionalities or methods of ToDoListEditTask class for
 * different scenarios of input .
 */
public class ToDoListEditTaskTest {
    /**
     * This Method is used to test whether the task can be edited with providing the non existent taskid .
     */

    @Test
    void checkIfWeCanEditTaskWithNonExistingTaskID()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);
        String expectedtaskValue = "002" + ";"+ "BluePrintXX" +";"+  "EINV0XX" + ";"+ "01/02/2019" + ";"+ "Pending";
        excepted_tasks.set(2,expectedtaskValue);
        todo.formatLoadArrayList(excepted_tasks);
        System.out.println("EX is"+excepted_tasks);
        editTodo.editTask(tasks,"004","BluePrintXX","EINV0XX","01/02/2019","Pending");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks,excepted_tasks );
    }
    /**
     * This Method is used to test whether the task can be edited with providing the wrong taskId .
     */
    @Test
    void checkIfWeCanEditTaskWithEnteringWrongTaskID()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);
        String expectedtaskValue = "002" + ";"+ "BluePrintXX" +";"+  "EINV0XX" + ";"+ "01/02/2019" + ";"+ "Pending";
        excepted_tasks.set(2,expectedtaskValue);
        todo.formatLoadArrayList(excepted_tasks);
        System.out.println("EX is"+excepted_tasks);
        editTodo.editTask(tasks,"Blue","BluePrintXX","EINV0XX","01/02/2019","Pending");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks,excepted_tasks );
    }
    /**
     * This Method is used to test whether the task can be removed with providing the specific taskid
     * whose values needs to be removed.
     */
    @Test
    void checkIfWeCanRemoveTaskByUsingTaskIdAsInput()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);

        excepted_tasks.remove(2);
       todo.formatLoadArrayList(excepted_tasks);

        editTodo.RemoveTaskIndex(tasks,"002");
        todo.formatLoadArrayList(tasks);
        assertEquals(tasks,excepted_tasks );
    }
    /**
     * This Method is used to test whether the task can be removed by providing the Non existing taskId.
     */
    @Test
    void ToCheckIfRemoveTaskWorksWithNonExistingTaskIDAsInput()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);

        excepted_tasks.remove(2);
        todo.formatLoadArrayList(excepted_tasks);

        editTodo.RemoveTaskIndex(tasks,"005");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks,excepted_tasks );
    }
    /**
     * This Method is used to test whether the task can be Marked as done by providing the specific taskid
     */
    @Test
    void markTaskStatusAsDoneByUsingTaskIdAsInput()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);
String excepted_markAsDone = "001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Done";
        excepted_tasks.set(1,excepted_markAsDone);

        todo.formatLoadArrayList(excepted_tasks);

        editTodo.MarkDone(tasks,"001");
        todo.formatLoadArrayList(tasks);
        assertEquals(tasks,excepted_tasks );
    }
    /**
     * This Method is used to test whether the task can be Marked as done by  providing the Non existing taskId.
     */
    @Test
    void markTaskStatusAsDoneWithNonExistingTaskID()
    {
        ToDoListEditTask editTodo = new ToDoListEditTask();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();


        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.addAll(tasks);
        String excepted_markAsDone = "001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Done";
        excepted_tasks.set(1,excepted_markAsDone);

        todo.formatLoadArrayList(excepted_tasks);

        editTodo.MarkDone(tasks,"004");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks,excepted_tasks );
    }

}
