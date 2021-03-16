import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
/**
 * The purpose of this class is to test various functionalities or methods of ToDoListCF(Common Functionalities) class for
 * various input .
 */
public class ToDoListCFTest {


    /**
     * This test Method The purpose of this method is to get the nth occurring index of a particular character in the string
     */
    @Test
    void CheckOrdinalIndexOfAString() {
        ToDoListCF ComFunc = new ToDoListCF();
        String input = "001;BluePrint;RPA1;25/03/2021;Pending ";
        String expected_output = "RPA1"; // This is the string between the Ordinal index 1 and 2 with ";" as the character

      int startIndex =   ComFunc.ordinalIndexOf(input, ";", 1);
      int endIndex =  ComFunc.ordinalIndexOf(input, ";", 2);
      String output = input.substring(startIndex+1,endIndex);
        assertEquals(expected_output,output);
    }
    @Test
    void CheckOrdinalIndexOfAStringAndCompareForIncorrectValue() {
        ToDoListCF ComFunc = new ToDoListCF();
        String input = "001;BluePrint;RPA1;25/03/2021;Pending ";
        String expected_output = "BluePrint";

        int startIndex =   ComFunc.ordinalIndexOf(input, ";", 1);
        int endIndex =  ComFunc.ordinalIndexOf(input, ";", 2);
        String output = input.substring(startIndex+1,endIndex);
        assertNotEquals(expected_output,output);
    }

    @Test
    void CheckRightPaddingForAgivenString() {
        String input = "BluePrint";
        String expected_output = "BluePrint######";
        ToDoListCF ComFunc = new ToDoListCF();

        assertEquals(ComFunc.rightPadding(input,'#',15),expected_output);
    }
    @Test
    void CheckRightPaddingForAGivenStringAndCompareWithIncorrectOutput() {
        String input = "BluePrint";
        String expected_output = "BluePrint##############";
        ToDoListCF ComFunc = new ToDoListCF();

        assertNotEquals(ComFunc.rightPadding(input,'#',15),expected_output);
    }
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private String provideInput(String data) {


        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        return "";
    }

@Test
    void CheckToReadProjectNameAsUserInputFromConsole()
    {
        String Input_Project = "AXA-CORPORATION-Private-LIMITED";
        String expected_Project = "AXA-CORPORATIO";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Project);

        String Output_Project = ComFunc.userInputProject(provideInput(Input_Project));
        assertEquals(Output_Project, expected_Project);

    }
    @Test
    void checkToReadProjectNameAsUserInputFromConsoleInCorrectLength()
    {
        String Input_Project = "AXA-CORPORATION-Private-LIMITED";
        String expected_Project = "AXA-CORPORATION-Private-";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Project);

        String Output_Project = ComFunc.userInputProject(provideInput(Input_Project));
        assertNotEquals(Output_Project, expected_Project);

    }
    @Test
    void checkToReadDateAsUserInputFromConsole()
    {
        String Input_Date = "22/05/2021";
        String expected_Date = "22/05/2021";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertEquals(Output_Date, expected_Date);

    }
    @Test
    void checkToReadDateInWrongFormatAsUserInputFromConsole() {
        String Input_Date = "22-03-2007";
        String expected_Date = "22/03/2007";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertNotEquals(Output_Date, expected_Date);
    }
}