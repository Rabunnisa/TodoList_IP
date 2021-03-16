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

/**
 * The purpose of this class is to test various functionalities or methods of this class for different scenarios of input .
 */
public class ToDoListTest {
    /**
     * This Method is used to test whether the given input task is stored in a consistent
     * format with appropriate spaces.
     */

    @Test
    void checkIftheTaskSavedIsInProperFormatWithFormatLoadArray() {
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        tasks.add("001" + ";" + "Design" + ";" + "RPA" + ";" + "21/03/2021" + ";" + "Pending");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001;      Design;             RPA;           21/03/2021;    Pending   ");
        todo.formatLoadArrayList(tasks);
        assertEquals(tasks, expected_tasks);

    }

    /**
     * This Method is used to the test whether the given input task is stored in a consistent
     * format with appropriate spaces for non formatted task .
     */
    @Test
    void formatLoadArrayListByComparingWithNonFormatArrayTest() {
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        tasks.add("001" + ";" + "Design" + ";" + "RPA" + ";" + "21/03/2021" + ";" + "Pending");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001; Design;    RPA;   21/03/2021;  Pending   ");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks, expected_tasks);


    }

    /**
     * This Method is used to the test whether the given input task is stored in a consistent
     * format with appropriate spaces for task added with empty values  .
     */
    @Test
    void formatLoadArrayListByComparingWithEmptyValue() {
        ToDoList todo = new ToDoList();
        List<String> tasks = new ArrayList<>();
        tasks.add("" + ";" + "" + ";" + "" + ";" + "" + ";" + "");
        List<String> expected_tasks = new ArrayList<>();
        expected_tasks.add("001; Design;    RPA;   21/03/2021;  Pending   ");
        todo.formatLoadArrayList(tasks);
        assertNotEquals(tasks, expected_tasks);
    }
}