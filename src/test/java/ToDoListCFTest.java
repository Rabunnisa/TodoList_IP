import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListCFTest {
    @Test
    void CheckOrdinalIndexOfAStiring() {
        ToDoListCF ComFunc = new ToDoListCF();
        String input = "001;BluePrint;RPA1;25/03/2021;Pending ";
        String expected_output = "RPA1"; // This is the string between the Ordinal index 1 and 2 with ";" as the character

      int startIndex =   ComFunc.ordinalIndexOf(input, ";", 1);
      int endIndex =  ComFunc.ordinalIndexOf(input, ";", 2);
      String output = input.substring(startIndex+1,endIndex);
        assertEquals(expected_output,output);
    }

    @Test
    void CheckRightPaddingForAgivenStirng() {
        String input = "BluePrint";
        String expected_output = "BluePrint######";
        ToDoListCF ComFunc = new ToDoListCF();

        assertEquals(ComFunc.rightPadding(input,'#',15),expected_output);
    }

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private String provideInput(String data) {


        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        return "";
    }

@Test
    void ReadProjectAsUserInputFromConsole()
    {
        String Input_Project = "AXA-CORPORATION-Private-LIMITED";
        String expected_Project = "AXA-CORPORATIO";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Project);

        String Output_Project = ComFunc.userInputProject(provideInput(Input_Project));
        assertEquals(Output_Project, expected_Project);

    }
    @Test
    void ReadDateAsUserInputFromConsole()
    {
        String Input_Date = "22/05/2021";
        String expected_Date = "22/05/2021";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertEquals(Output_Date, expected_Date);

    }
    @Test
    void ReadDateAsUserInputFromConsoleisEmpty() {
        String Input_Date = "";
        String expected_Date = "22/03/2007";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertEquals(Output_Date, expected_Date);
    }
}