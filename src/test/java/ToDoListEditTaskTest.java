import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListCF;
import com.sda.kth.ToDoListDisplayTaskList;
import com.sda.kth.ToDoListEditTask;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ToDoListEditTaskTest {


    @Test
    void editTaskWithNonExistingTaskID()
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
    @Test
    void removeTaskByUsingTaskIdAsInput()
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
    @Test
    void removeTaskWithNonExistingTaskIDAsInput()
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
