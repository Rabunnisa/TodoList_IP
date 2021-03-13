import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListTest {
    /**
     * This Method is used to test whether the given input task is stored in a consistent
     * format with appropriate spaces.
     */

    @Test
    void formatLoadArrayListTest()
    {ToDoList todo = new ToDoList();
    List<String> tasks = new ArrayList<>();
    tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001;      Design;             RPA;           21/03/2021;    Pending   ");


   todo.formatLoadArrayList(tasks);
   assertEquals(tasks,expected_tasks );

    }

    /**
     * This method is used to check the calculate the number of tasks which are pending and done in the initial task list.
     */
    @Test
    void calculateNumberOfPendingDoneTaskTest()
{ToDoList todo = new ToDoList();
    List<String> tasks = new ArrayList<>();
    tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
    tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
    tasks.add("002" + ";"+ "Design1" +";"+  "RPEM" + ";"+ "03/03/2021" + ";"+ "Done");
    tasks.add("003" + ";"+ "Design" +";"+  "EINV" + ";"+ "22/03/2021" + ";"+ "Pending");
    int expected_pendingTask = 2;
    int expected_doneTask = 1;
    int doneTasks = 0;
    int pendingTasks = 0;
    int beginIndexStatus = 0;
    int endIndexStatus = 0;
    for (int i = 1; i < tasks.size(); i++) {
        String checkStatus = "";
        String taskVal = tasks.get(i);
        beginIndexStatus = ToDoListCF.ordinalIndexOf(taskVal, ";", 3);
        endIndexStatus = taskVal.length();

        checkStatus = taskVal.substring(beginIndexStatus + 1, endIndexStatus);

        if (checkStatus.trim().equalsIgnoreCase("Pending"))
            pendingTasks++;
        else
            doneTasks++;

    }
    assertEquals(pendingTasks,expected_pendingTask);
    assertEquals(doneTasks,expected_doneTask);
}
}
