import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListAddTask;
import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ToDoListAddTaskTest {

    @Test
    void CheckWhetherTheGivenTaskIsAdded()
    {ToDoListAddTask aTask = new ToDoListAddTask();
        List<String> tasks = new ArrayList<>();
        List<String> TaskID = new ArrayList<>();
        List<String> tasks_Project = new ArrayList<>();
        List<String> tasks_Date = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();

        TaskID.add("001");
        TaskID.add("002");
        tasks_Project.add("RPA");
        tasks_Project.add("RPEM");
        tasks_Date.add("21/03/2021");
        tasks_Date.add("03/03/2021");
        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "Design1" +";"+  "RPEM" + ";"+ "03/03/2021" + ";"+ "Done");
        excepted_tasks.addAll(tasks);

        String expected_TaskID = "003";
        String expected_tasksTitle = "BluePrint";
        String expected_Project = "EINV";
        String expected_DueDate = "22/05/2021";
        excepted_tasks.add(expected_TaskID  + ";"+ expected_tasksTitle  + ";"+expected_Project+ ";"+expected_DueDate+ ";"+ "Pending");

        aTask.AddTask(tasks,TaskID,tasks_Project,tasks_Date,"BluePrint","EINV","22/05/2021");

        assertEquals(tasks,excepted_tasks );


    }



}
