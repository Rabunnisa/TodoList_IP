import com.sda.kth.ToDoList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListTest {


    @Test
    void formatLoadArrayListTest()
    {ToDoList todo = new ToDoList();
    List<String> tasks = new ArrayList<>();
    tasks.add("001" + ";"+ "Design" +";"+  "RPA" + ";"+ "21/03/2021" + ";"+ "Pending");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001;      Design;             RPE;           21/03/2021;    Pending   ");


   todo.formatLoadArrayList(tasks);
   assertEquals(tasks,expected_tasks );

    }



}
