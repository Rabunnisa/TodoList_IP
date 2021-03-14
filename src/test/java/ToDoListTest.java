import com.sda.kth.ToDoList;
import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
    @Test
    void formatLoadArrayListByComparingWithNonFormatArrayTest()
    {ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001; Design;    RPA;   21/03/2021;  Pending   ");


        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks,expected_tasks );

    }

}
