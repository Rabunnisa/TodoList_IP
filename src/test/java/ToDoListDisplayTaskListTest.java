import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListDisplayTaskList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoListDisplayTaskListTest {
@Test
    void toDisplayTheCurrentTaskListByProjectTest()
{
    ToDoListDisplayTaskList toProject = new ToDoListDisplayTaskList();
    ToDoList todo = new ToDoList();
    List<String> tasks = new ArrayList<>();

    List<String> tasks_Project = new ArrayList<>();
    List<String> sortByProject = new ArrayList<>();
    List<String> excepted_tasks = new ArrayList<>();

    tasks_Project.add("Project");
    tasks_Project.add("RPA");
    tasks_Project.add("EINV0");
    tasks_Project.add("EINV1");

    tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
    tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
    tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2021" + ";"+ "Done");
    tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2021" + ";"+ "Done");
    sortByProject.addAll(tasks);
    excepted_tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
    excepted_tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2021" + ";"+ "Done");
    excepted_tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2021" + ";"+ "Done");
    excepted_tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
    todo.formatLoadArrayList(excepted_tasks);

    toProject.displayTaskListByProject( tasks, sortByProject,
             tasks_Project);

    assertEquals(sortByProject,excepted_tasks );

}

    @Test
    void toDisplayTheCurrentTaskListByDateTest()
    {
        ToDoListDisplayTaskList toDate = new ToDoListDisplayTaskList();
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();

        List<String> tasks_Date = new ArrayList<>();
        List<String> sortByDate = new ArrayList<>();
        List<String> excepted_tasks = new ArrayList<>();
        List<Date> dateList = new ArrayList<>();

        tasks_Date.add("DueDate");
        tasks_Date.add("21/03/2021");
        tasks_Date.add("03/01/2020");
        tasks_Date.add("03/02/2019");

        tasks.add("TaskID;   TaskTitle;          Project;       DueDate;       Status  ");
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        sortByDate.addAll(tasks);

        excepted_tasks.add("003" + ";"+ "Code" +";"+  "EINV1" + ";"+ "03/02/2019" + ";"+ "Done");
        excepted_tasks.add("002" + ";"+ "BluePrint" +";"+  "EINV0" + ";"+ "03/01/2020" + ";"+ "Done");
        excepted_tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        todo.formatLoadArrayList(excepted_tasks);

        toDate.displayTaskListByDate(  tasks, tasks_Date,  sortByDate,
                 dateList);

        assertEquals(sortByDate,excepted_tasks );

}

}